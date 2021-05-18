package org.hay.overlay.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.hay.overlay.message.Message;
import org.hay.overlay.message.Type;

import static org.hay.core.Constant.TOPIC_BLOCK;

public class ConsumerWorker implements Runnable {

    private ConsumerRecord<String, String> record;
    private Kafka kafka;

    public ConsumerWorker(ConsumerRecord<String, String> record, Kafka kafka) {
        this.record = record;
        this.kafka = kafka;
    }

    @Override
    public void run() {
        Message message = new Message();
        message.setType(record.topic().equals(TOPIC_BLOCK) ? Type.BLOCK : Type.TRANSACTION);
        message.setMessage(record.value());

        kafka.deliver(message);
    }
}
