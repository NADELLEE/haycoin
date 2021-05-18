// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: core/hayTXInput.proto

package org.hay.protos.core;

public final class hayTXInput {
  private hayTXInput() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface TXInputOrBuilder extends
      // @@protoc_insertion_point(interface_extends:protos.TXInput)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>bytes txID = 1;</code>
     */
    com.google.protobuf.ByteString getTxID();

    /**
     * <code>int64 vout = 2;</code>
     */
    long getVout();

    /**
     * <code>bytes signature = 3;</code>
     */
    com.google.protobuf.ByteString getSignature();

    /**
     * <code>bytes pubKey = 4;</code>
     */
    com.google.protobuf.ByteString getPubKey();
  }
  /**
   * Protobuf type {@code protos.TXInput}
   */
  public  static final class TXInput extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:protos.TXInput)
      TXInputOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use TXInput.newBuilder() to construct.
    private TXInput(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private TXInput() {
      txID_ = com.google.protobuf.ByteString.EMPTY;
      vout_ = 0L;
      signature_ = com.google.protobuf.ByteString.EMPTY;
      pubKey_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private TXInput(
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
            case 10: {

              txID_ = input.readBytes();
              break;
            }
            case 16: {

              vout_ = input.readInt64();
              break;
            }
            case 26: {

              signature_ = input.readBytes();
              break;
            }
            case 34: {

              pubKey_ = input.readBytes();
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
      return org.hay.protos.core.hayTXInput.internal_static_protos_TXInput_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.hay.protos.core.hayTXInput.internal_static_protos_TXInput_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.hay.protos.core.hayTXInput.TXInput.class, org.hay.protos.core.hayTXInput.TXInput.Builder.class);
    }

    public static final int TXID_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString txID_;
    /**
     * <code>bytes txID = 1;</code>
     */
    public com.google.protobuf.ByteString getTxID() {
      return txID_;
    }

    public static final int VOUT_FIELD_NUMBER = 2;
    private long vout_;
    /**
     * <code>int64 vout = 2;</code>
     */
    public long getVout() {
      return vout_;
    }

    public static final int SIGNATURE_FIELD_NUMBER = 3;
    private com.google.protobuf.ByteString signature_;
    /**
     * <code>bytes signature = 3;</code>
     */
    public com.google.protobuf.ByteString getSignature() {
      return signature_;
    }

    public static final int PUBKEY_FIELD_NUMBER = 4;
    private com.google.protobuf.ByteString pubKey_;
    /**
     * <code>bytes pubKey = 4;</code>
     */
    public com.google.protobuf.ByteString getPubKey() {
      return pubKey_;
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
      if (!txID_.isEmpty()) {
        output.writeBytes(1, txID_);
      }
      if (vout_ != 0L) {
        output.writeInt64(2, vout_);
      }
      if (!signature_.isEmpty()) {
        output.writeBytes(3, signature_);
      }
      if (!pubKey_.isEmpty()) {
        output.writeBytes(4, pubKey_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!txID_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, txID_);
      }
      if (vout_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, vout_);
      }
      if (!signature_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, signature_);
      }
      if (!pubKey_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, pubKey_);
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
      if (!(obj instanceof org.hay.protos.core.hayTXInput.TXInput)) {
        return super.equals(obj);
      }
      org.hay.protos.core.hayTXInput.TXInput other = (org.hay.protos.core.hayTXInput.TXInput) obj;

      boolean result = true;
      result = result && getTxID()
          .equals(other.getTxID());
      result = result && (getVout()
          == other.getVout());
      result = result && getSignature()
          .equals(other.getSignature());
      result = result && getPubKey()
          .equals(other.getPubKey());
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
      hash = (37 * hash) + TXID_FIELD_NUMBER;
      hash = (53 * hash) + getTxID().hashCode();
      hash = (37 * hash) + VOUT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getVout());
      hash = (37 * hash) + SIGNATURE_FIELD_NUMBER;
      hash = (53 * hash) + getSignature().hashCode();
      hash = (37 * hash) + PUBKEY_FIELD_NUMBER;
      hash = (53 * hash) + getPubKey().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.hay.protos.core.hayTXInput.TXInput parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.hay.protos.core.hayTXInput.TXInput parseFrom(
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
    public static Builder newBuilder(org.hay.protos.core.hayTXInput.TXInput prototype) {
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
     * Protobuf type {@code protos.TXInput}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:protos.TXInput)
        org.hay.protos.core.hayTXInput.TXInputOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.hay.protos.core.hayTXInput.internal_static_protos_TXInput_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.hay.protos.core.hayTXInput.internal_static_protos_TXInput_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.hay.protos.core.hayTXInput.TXInput.class, org.hay.protos.core.hayTXInput.TXInput.Builder.class);
      }

      // Construct using org.hay.protos.core.hayTXInput.TXInput.newBuilder()
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
        txID_ = com.google.protobuf.ByteString.EMPTY;

        vout_ = 0L;

        signature_ = com.google.protobuf.ByteString.EMPTY;

        pubKey_ = com.google.protobuf.ByteString.EMPTY;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.hay.protos.core.hayTXInput.internal_static_protos_TXInput_descriptor;
      }

      public org.hay.protos.core.hayTXInput.TXInput getDefaultInstanceForType() {
        return org.hay.protos.core.hayTXInput.TXInput.getDefaultInstance();
      }

      public org.hay.protos.core.hayTXInput.TXInput build() {
        org.hay.protos.core.hayTXInput.TXInput result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public org.hay.protos.core.hayTXInput.TXInput buildPartial() {
        org.hay.protos.core.hayTXInput.TXInput result = new org.hay.protos.core.hayTXInput.TXInput(this);
        result.txID_ = txID_;
        result.vout_ = vout_;
        result.signature_ = signature_;
        result.pubKey_ = pubKey_;
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
        if (other instanceof org.hay.protos.core.hayTXInput.TXInput) {
          return mergeFrom((org.hay.protos.core.hayTXInput.TXInput)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.hay.protos.core.hayTXInput.TXInput other) {
        if (other == org.hay.protos.core.hayTXInput.TXInput.getDefaultInstance()) return this;
        if (other.getTxID() != com.google.protobuf.ByteString.EMPTY) {
          setTxID(other.getTxID());
        }
        if (other.getVout() != 0L) {
          setVout(other.getVout());
        }
        if (other.getSignature() != com.google.protobuf.ByteString.EMPTY) {
          setSignature(other.getSignature());
        }
        if (other.getPubKey() != com.google.protobuf.ByteString.EMPTY) {
          setPubKey(other.getPubKey());
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
        org.hay.protos.core.hayTXInput.TXInput parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (org.hay.protos.core.hayTXInput.TXInput) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private com.google.protobuf.ByteString txID_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes txID = 1;</code>
       */
      public com.google.protobuf.ByteString getTxID() {
        return txID_;
      }
      /**
       * <code>bytes txID = 1;</code>
       */
      public Builder setTxID(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        txID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes txID = 1;</code>
       */
      public Builder clearTxID() {
        
        txID_ = getDefaultInstance().getTxID();
        onChanged();
        return this;
      }

      private long vout_ ;
      /**
       * <code>int64 vout = 2;</code>
       */
      public long getVout() {
        return vout_;
      }
      /**
       * <code>int64 vout = 2;</code>
       */
      public Builder setVout(long value) {
        
        vout_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 vout = 2;</code>
       */
      public Builder clearVout() {
        
        vout_ = 0L;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString signature_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes signature = 3;</code>
       */
      public com.google.protobuf.ByteString getSignature() {
        return signature_;
      }
      /**
       * <code>bytes signature = 3;</code>
       */
      public Builder setSignature(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        signature_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes signature = 3;</code>
       */
      public Builder clearSignature() {
        
        signature_ = getDefaultInstance().getSignature();
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString pubKey_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes pubKey = 4;</code>
       */
      public com.google.protobuf.ByteString getPubKey() {
        return pubKey_;
      }
      /**
       * <code>bytes pubKey = 4;</code>
       */
      public Builder setPubKey(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        pubKey_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes pubKey = 4;</code>
       */
      public Builder clearPubKey() {
        
        pubKey_ = getDefaultInstance().getPubKey();
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


      // @@protoc_insertion_point(builder_scope:protos.TXInput)
    }

    // @@protoc_insertion_point(class_scope:protos.TXInput)
    private static final org.hay.protos.core.hayTXInput.TXInput DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.hay.protos.core.hayTXInput.TXInput();
    }

    public static org.hay.protos.core.hayTXInput.TXInput getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TXInput>
        PARSER = new com.google.protobuf.AbstractParser<TXInput>() {
      public TXInput parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new TXInput(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<TXInput> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TXInput> getParserForType() {
      return PARSER;
    }

    public org.hay.protos.core.hayTXInput.TXInput getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protos_TXInput_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protos_TXInput_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026core/hayTXInput.proto\022\006protos\"H\n\007TXIn" +
      "put\022\014\n\004txID\030\001 \001(\014\022\014\n\004vout\030\002 \001(\003\022\021\n\tsigna" +
      "ture\030\003 \001(\014\022\016\n\006pubKey\030\004 \001(\014B#\n\024org.hay.p" +
      "rotos.coreB\013hayTXInputb\006proto3"
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
    internal_static_protos_TXInput_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_protos_TXInput_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protos_TXInput_descriptor,
        new java.lang.String[] { "TxID", "Vout", "Signature", "PubKey", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
