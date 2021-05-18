// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: core/hayTXOutput.proto

package org.hay.protos.core;

public final class hayTXOutput {
  private hayTXOutput() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface TXOutputOrBuilder extends
      // @@protoc_insertion_point(interface_extends:protos.TXOutput)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 value = 1;</code>
     */
    long getValue();

    /**
     * <code>bytes pubKeyHash = 2;</code>
     */
    com.google.protobuf.ByteString getPubKeyHash();
  }
  /**
   * Protobuf type {@code protos.TXOutput}
   */
  public  static final class TXOutput extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:protos.TXOutput)
      TXOutputOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use TXOutput.newBuilder() to construct.
    private TXOutput(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private TXOutput() {
      value_ = 0L;
      pubKeyHash_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private TXOutput(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              value_ = input.readInt64();
              break;
            }
            case 18: {

              pubKeyHash_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.hay.protos.core.hayTXOutput.internal_static_protos_TXOutput_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.hay.protos.core.hayTXOutput.internal_static_protos_TXOutput_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.hay.protos.core.hayTXOutput.TXOutput.class, org.hay.protos.core.hayTXOutput.TXOutput.Builder.class);
    }

    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;
    /**
     * <code>int64 value = 1;</code>
     */
    public long getValue() {
      return value_;
    }

    public static final int PUBKEYHASH_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString pubKeyHash_;
    /**
     * <code>bytes pubKeyHash = 2;</code>
     */
    public com.google.protobuf.ByteString getPubKeyHash() {
      return pubKeyHash_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (value_ != 0L) {
        output.writeInt64(1, value_);
      }
      if (!pubKeyHash_.isEmpty()) {
        output.writeBytes(2, pubKeyHash_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (value_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, value_);
      }
      if (!pubKeyHash_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, pubKeyHash_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof org.hay.protos.core.hayTXOutput.TXOutput)) {
        return super.equals(obj);
      }
      org.hay.protos.core.hayTXOutput.TXOutput other = (org.hay.protos.core.hayTXOutput.TXOutput) obj;

      boolean result = true;
      result = result && (getValue()
          == other.getValue());
      result = result && getPubKeyHash()
          .equals(other.getPubKeyHash());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getValue());
      hash = (37 * hash) + PUBKEYHASH_FIELD_NUMBER;
      hash = (53 * hash) + getPubKeyHash().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.hay.protos.core.hayTXOutput.TXOutput parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.hay.protos.core.hayTXOutput.TXOutput parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(org.hay.protos.core.hayTXOutput.TXOutput prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code protos.TXOutput}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:protos.TXOutput)
        org.hay.protos.core.hayTXOutput.TXOutputOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.hay.protos.core.hayTXOutput.internal_static_protos_TXOutput_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.hay.protos.core.hayTXOutput.internal_static_protos_TXOutput_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.hay.protos.core.hayTXOutput.TXOutput.class, org.hay.protos.core.hayTXOutput.TXOutput.Builder.class);
      }

      // Construct using org.hay.protos.core.hayTXOutput.TXOutput.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        value_ = 0L;

        pubKeyHash_ = com.google.protobuf.ByteString.EMPTY;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.hay.protos.core.hayTXOutput.internal_static_protos_TXOutput_descriptor;
      }

      public org.hay.protos.core.hayTXOutput.TXOutput getDefaultInstanceForType() {
        return org.hay.protos.core.hayTXOutput.TXOutput.getDefaultInstance();
      }

      public org.hay.protos.core.hayTXOutput.TXOutput build() {
        org.hay.protos.core.hayTXOutput.TXOutput result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public org.hay.protos.core.hayTXOutput.TXOutput buildPartial() {
        org.hay.protos.core.hayTXOutput.TXOutput result = new org.hay.protos.core.hayTXOutput.TXOutput(this);
        result.value_ = value_;
        result.pubKeyHash_ = pubKeyHash_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.hay.protos.core.hayTXOutput.TXOutput) {
          return mergeFrom((org.hay.protos.core.hayTXOutput.TXOutput)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.hay.protos.core.hayTXOutput.TXOutput other) {
        if (other == org.hay.protos.core.hayTXOutput.TXOutput.getDefaultInstance()) return this;
        if (other.getValue() != 0L) {
          setValue(other.getValue());
        }
        if (other.getPubKeyHash() != com.google.protobuf.ByteString.EMPTY) {
          setPubKeyHash(other.getPubKeyHash());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        org.hay.protos.core.hayTXOutput.TXOutput parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (org.hay.protos.core.hayTXOutput.TXOutput) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long value_ ;
      /**
       * <code>int64 value = 1;</code>
       */
      public long getValue() {
        return value_;
      }
      /**
       * <code>int64 value = 1;</code>
       */
      public Builder setValue(long value) {
        
        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 value = 1;</code>
       */
      public Builder clearValue() {
        
        value_ = 0L;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString pubKeyHash_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes pubKeyHash = 2;</code>
       */
      public com.google.protobuf.ByteString getPubKeyHash() {
        return pubKeyHash_;
      }
      /**
       * <code>bytes pubKeyHash = 2;</code>
       */
      public Builder setPubKeyHash(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        pubKeyHash_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes pubKeyHash = 2;</code>
       */
      public Builder clearPubKeyHash() {
        
        pubKeyHash_ = getDefaultInstance().getPubKeyHash();
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:protos.TXOutput)
    }

    // @@protoc_insertion_point(class_scope:protos.TXOutput)
    private static final org.hay.protos.core.hayTXOutput.TXOutput DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.hay.protos.core.hayTXOutput.TXOutput();
    }

    public static org.hay.protos.core.hayTXOutput.TXOutput getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TXOutput>
        PARSER = new com.google.protobuf.AbstractParser<TXOutput>() {
      public TXOutput parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new TXOutput(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<TXOutput> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TXOutput> getParserForType() {
      return PARSER;
    }

    public org.hay.protos.core.hayTXOutput.TXOutput getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protos_TXOutput_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protos_TXOutput_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027core/hayTXOutput.proto\022\006protos\"-\n\010TXO" +
      "utput\022\r\n\005value\030\001 \001(\003\022\022\n\npubKeyHash\030\002 \001(\014" +
      "B$\n\024org.hay.protos.coreB\014hayTXOutputb\006" +
      "proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_protos_TXOutput_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_protos_TXOutput_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protos_TXOutput_descriptor,
        new java.lang.String[] { "Value", "PubKeyHash", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
