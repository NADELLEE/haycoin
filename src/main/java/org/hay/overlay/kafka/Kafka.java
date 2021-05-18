package org.hay.overlay.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.hay.overlay.Net;
import org.hay.overlay.listener.ReceiveSource;
import org.hay.overlay.message.Message;
import org.hay.overlay.message.Type;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.hay.core.Constant.*;

public class Kafka implements Net {
    private final static String EMPTY_KEY = "";
    private final static int DEFAULT_WORKER_NUM = 4;

    private KafkaProducer<String, String> producer = null;
    private KafkaConsumer<String, String> consumer = null;

    private ProducerProperty producerProperty = null;
    private ConsumerProperty consumerProperty = null;

    private ExecutorService executors;

    private ReceiveSource source;

    private List<String> topics;

    public Kafka() {
        this(ProducerProperty.getDefault(), ConsumerProperty.getDefault(), null, null);
    }

    public Kafka(ReceiveSource source, List<String> topics) {
        this(ProducerProperty.getDefault(), ConsumerProperty.getDefault(), source, topics);
    }

    public Kafka(ProducerProperty producerProperty, ConsumerProperty consumerProperty, ReceiveSource source,
                 List<String> topics) {
        this.producerProperty = producerProperty;
        this.consumerProperty = consumerProperty;
        this.source = source;
        this.topics = topics;
        Properties producerProperties = getProducerProperties();
        Properties consumerProperties = getConsumerProperties();
        producer = new KafkaProducer<String, String>(producerProperties);
        consumer = new KafkaConsumer<String, String>(consumerProperties);
        consumer.subscribe(topics);
        consumerExecute(DEFAULT_WORKER_NUM);
    }

    public KafkaProducer<String, String> getProducer() {
        return producer;
    }

    public KafkaConsumer<String, String> getConsumer() {
        return consumer;
    }

    private Properties getProducerProperties() {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", producerProperty.getBootstrapServers());
        properties.put("acks", producerProperty.getAcks());
        properties.put("retries", producerProperty.getRetries());
        properties.put("batch.size", producerProperty.getBatchSize());
        properties.put("linger.ms", producerProperty.getLingerMS());
        properties.put("buffer.memory", producerProperty.getBufferMemory());
        properties.put("key.serializer", producerProperty.getKeySerializer());
        properties.put("value.serializer", producerProperty.getValueSerializer());

        return properties;
    }

    private Properties getConsumerProperties() {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", consumerProperty.getBootstrapServers());
        properties.put("group.id", consumerProperty.getGroupID());
        properties.put("enable.auto.commit", consumerProperty.getEnableAutoCommit());
        properties.put("auto.commit.interval.ms", consumerProperty.getAutoCommitIntervalMS());
        properties.put("session.timeout.ms", consumerProperty.getSessionTimeoutMS());
        properties.put("key.deserializer", consumerProperty.getKeyDeserializer());
        properties.put("value.deserializer", consumerProperty.getValueDeserializer());

        return properties;
    }

    private void send(String topic, Integer partition, String key, String value) {
        producer.send(new ProducerRecord<String, String>(topic, partition, key, value));
    }

    private void consumerExecute(int workerNum) {
        executors = new ThreadPoolExecutor(workerNum, workerNum, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>
                (1000), new ThreadPoolExecutor.CallerRunsPolicy());

        Thread thread = new Thread(() -> {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(200);

                for (final ConsumerRecord<String, String> record : records) {
                    executors.submit(new ConsumerWorker(record, this));
                }
            }
        });

        thread.start();
    }

    public void shutdown() {
        // TODO: must solve thread unsafe program
//        if (consumer != null) {
//            consumer.close();
//        }

        if (executors != null) {
            executors.shutdown();
        }

        try {
            if (!executors.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("timeout, ignore for this case");
            }
        } catch (InterruptedException e) {
            System.out.println("other thread interrupted this shutdown, ignore for this case");
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void broadcast(Message message) {
        String topic = "";
        String value = message.getMessage();

        if (message.getType() == Type.BLOCK) {
            topic = TOPIC_BLOCK;
        } else if (message.getType() == Type.TRANSACTION) {
            topic = TOPIC_TRANSACTION;
        }

        send(topic, PARTITION, EMPTY_KEY, value);
    }

    @Override
    public void deliver(Message messages) {
        source.notifyReceiveEvent(messages);
    }
}
