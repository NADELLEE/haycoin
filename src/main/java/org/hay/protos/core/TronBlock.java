// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: core/hayBlock.proto

package org.hay.protos.core;

public final class hayBlock {
  private hayBlock() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface BlockOrBuilder extends
      // @@protoc_insertion_point(interface_extends:protos.Block)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .protos.Transaction transactions = 1;</code>
     */
    java.util.List<org.hay.protos.core.hayTransaction.Transaction>
        getTransactionsList();
    /**
     * <code>repeated .protos.Transaction transactions = 1;</code>
     */
    org.hay.protos.core.hayTransaction.Transaction getTransactions(int index);
    /**
     * <code>repeated .protos.Transaction transactions = 1;</code>
     */
    int getTransactionsCount();
    /**
     * <code>repeated .protos.Transaction transactions = 1;</code>
     */
    java.util.List<? extends org.hay.protos.core.hayTransaction.TransactionOrBuilder>
        getTransactionsOrBuilderList();
    /**
     * <code>repeated .protos.Transaction transactions = 1;</code>
     */
    org.hay.protos.core.hayTransaction.TransactionOrBuilder getTransactionsOrBuilder(
        int index);

    /**
     * <code>.protos.BlockHeader blockHeader = 2;</code>
     */
    boolean hasBlockHeader();
    /**
     * <code>.protos.BlockHeader blockHeader = 2;</code>
     */
    org.hay.protos.core.hayBlockHeader.BlockHeader getBlockHeader();
    /**
     * <code>.protos.BlockHeader blockHeader = 2;</code>
     */
    org.hay.protos.core.hayBlockHeader.BlockHeaderOrBuilder getBlockHeaderOrBuilder();
  }
  /**
   * Protobuf type {@code protos.Block}
   */
  public  static final class Block extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:protos.Block)
      BlockOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Block.newBuilder() to construct.
    private Block(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Block() {
      transactions_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Block(
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
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                transactions_ = new java.util.ArrayList<org.hay.protos.core.hayTransaction.Transaction>();
                mutable_bitField0_ |= 0x00000001;
              }
              transactions_.add(
                  input.readMessage(org.hay.protos.core.hayTransaction.Transaction.parser(), extensionRegistry));
              break;
            }
            case 18: {
              org.hay.protos.core.hayBlockHeader.BlockHeader.Builder subBuilder = null;
              if (blockHeader_ != null) {
                subBuilder = blockHeader_.toBuilder();
              }
              blockHeader_ = input.readMessage(org.hay.protos.core.hayBlockHeader.BlockHeader.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(blockHeader_);
                blockHeader_ = subBuilder.buildPartial();
              }

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
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          transactions_ = java.util.Collections.unmodifiableList(transactions_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.hay.protos.core.hayBlock.internal_static_protos_Block_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.hay.protos.core.hayBlock.internal_static_protos_Block_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.hay.protos.core.hayBlock.Block.class, org.hay.protos.core.hayBlock.Block.Builder.class);
    }

    private int bitField0_;
    public static final int TRANSACTIONS_FIELD_NUMBER = 1;
    private java.util.List<org.hay.protos.core.hayTransaction.Transaction> transactions_;
    /**
     * <code>repeated .protos.Transaction transactions = 1;</code>
     */
    public java.util.List<org.hay.protos.core.hayTransaction.Transaction> getTransactionsList() {
      return transactions_;
    }
    /**
     * <code>repeated .protos.Transaction transactions = 1;</code>
     */
    public java.util.List<? extends org.hay.protos.core.hayTransaction.TransactionOrBuilder>
        getTransactionsOrBuilderList() {
      return transactions_;
    }
    /**
     * <code>repeated .protos.Transaction transactions = 1;</code>
     */
    public int getTransactionsCount() {
      return transactions_.size();
    }
    /**
     * <code>repeated .protos.Transaction transactions = 1;</code>
     */
    public org.hay.protos.core.hayTransaction.Transaction getTransactions(int index) {
      return transactions_.get(index);
    }
    /**
     * <code>repeated .protos.Transaction transactions = 1;</code>
     */
    public org.hay.protos.core.hayTransaction.TransactionOrBuilder getTransactionsOrBuilder(
        int index) {
      return transactions_.get(index);
    }

    public static final int BLOCKHEADER_FIELD_NUMBER = 2;
    private org.hay.protos.core.hayBlockHeader.BlockHeader blockHeader_;
    /**
     * <code>.protos.BlockHeader blockHeader = 2;</code>
     */
    public boolean hasBlockHeader() {
      return blockHeader_ != null;
    }
    /**
     * <code>.protos.BlockHeader blockHeader = 2;</code>
     */
    public org.hay.protos.core.hayBlockHeader.BlockHeader getBlockHeader() {
      return blockHeader_ == null ? org.hay.protos.core.hayBlockHeader.BlockHeader.getDefaultInstance() : blockHeader_;
    }
    /**
     * <code>.protos.BlockHeader blockHeader = 2;</code>
     */
    public org.hay.protos.core.hayBlockHeader.BlockHeaderOrBuilder getBlockHeaderOrBuilder() {
      return getBlockHeader();
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
      for (int i = 0; i < transactions_.size(); i++) {
        output.writeMessage(1, transactions_.get(i));
      }
      if (blockHeader_ != null) {
        output.writeMessage(2, getBlockHeader());
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < transactions_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, transactions_.get(i));
      }
      if (blockHeader_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getBlockHeader());
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
      if (!(obj instanceof org.hay.protos.core.hayBlock.Block)) {
        return super.equals(obj);
      }
      org.hay.protos.core.hayBlock.Block other = (org.hay.protos.core.hayBlock.Block) obj;

      boolean result = true;
      result = result && getTransactionsList()
          .equals(other.getTransactionsList());
      result = result && (hasBlockHeader() == other.hasBlockHeader());
      if (hasBlockHeader()) {
        result = result && getBlockHeader()
            .equals(other.getBlockHeader());
      }
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
      if (getTransactionsCount() > 0) {
        hash = (37 * hash) + TRANSACTIONS_FIELD_NUMBER;
        hash = (53 * hash) + getTransactionsList().hashCode();
      }
      if (hasBlockHeader()) {
        hash = (37 * hash) + BLOCKHEADER_FIELD_NUMBER;
        hash = (53 * hash) + getBlockHeader().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.hay.protos.core.hayBlock.Block parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.hay.protos.core.hayBlock.Block parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.hay.protos.core.hayBlock.Block parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.hay.protos.core.hayBlock.Block parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.hay.protos.core.hayBlock.Block parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.hay.protos.core.hayBlock.Block parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.hay.protos.core.hayBlock.Block parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.hay.protos.core.hayBlock.Block parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.hay.protos.core.hayBlock.Block parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.hay.protos.core.hayBlock.Block parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.hay.protos.core.hayBlock.Block parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.hay.protos.core.hayBlock.Block parseFrom(
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
    public static Builder newBuilder(org.hay.protos.core.hayBlock.Block prototype) {
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
     * Protobuf type {@code protos.Block}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:protos.Block)
        org.hay.protos.core.hayBlock.BlockOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.hay.protos.core.hayBlock.internal_static_protos_Block_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.hay.protos.core.hayBlock.internal_static_protos_Block_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.hay.protos.core.hayBlock.Block.class, org.hay.protos.core.hayBlock.Block.Builder.class);
      }

      // Construct using org.hay.protos.core.hayBlock.Block.newBuilder()
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
          getTransactionsFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        if (transactionsBuilder_ == null) {
          transactions_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          transactionsBuilder_.clear();
        }
        if (blockHeaderBuilder_ == null) {
          blockHeader_ = null;
        } else {
          blockHeader_ = null;
          blockHeaderBuilder_ = null;
        }
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.hay.protos.core.hayBlock.internal_static_protos_Block_descriptor;
      }

      public org.hay.protos.core.hayBlock.Block getDefaultInstanceForType() {
        return org.hay.protos.core.hayBlock.Block.getDefaultInstance();
      }

      public org.hay.protos.core.hayBlock.Block build() {
        org.hay.protos.core.hayBlock.Block result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public org.hay.protos.core.hayBlock.Block buildPartial() {
        org.hay.protos.core.hayBlock.Block result = new org.hay.protos.core.hayBlock.Block(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (transactionsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) == 0x00000001)) {
            transactions_ = java.util.Collections.unmodifiableList(transactions_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.transactions_ = transactions_;
        } else {
          result.transactions_ = transactionsBuilder_.build();
        }
        if (blockHeaderBuilder_ == null) {
          result.blockHeader_ = blockHeader_;
        } else {
          result.blockHeader_ = blockHeaderBuilder_.build();
        }
        result.bitField0_ = to_bitField0_;
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
        if (other instanceof org.hay.protos.core.hayBlock.Block) {
          return mergeFrom((org.hay.protos.core.hayBlock.Block)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.hay.protos.core.hayBlock.Block other) {
        if (other == org.hay.protos.core.hayBlock.Block.getDefaultInstance()) return this;
        if (transactionsBuilder_ == null) {
          if (!other.transactions_.isEmpty()) {
            if (transactions_.isEmpty()) {
              transactions_ = other.transactions_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureTransactionsIsMutable();
              transactions_.addAll(other.transactions_);
            }
            onChanged();
          }
        } else {
          if (!other.transactions_.isEmpty()) {
            if (transactionsBuilder_.isEmpty()) {
              transactionsBuilder_.dispose();
              transactionsBuilder_ = null;
              transactions_ = other.transactions_;
              bitField0_ = (bitField0_ & ~0x00000001);
              transactionsBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getTransactionsFieldBuilder() : null;
            } else {
              transactionsBuilder_.addAllMessages(other.transactions_);
            }
          }
        }
        if (other.hasBlockHeader()) {
          mergeBlockHeader(other.getBlockHeader());
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
        org.hay.protos.core.hayBlock.Block parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (org.hay.protos.core.hayBlock.Block) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<org.hay.protos.core.hayTransaction.Transaction> transactions_ =
        java.util.Collections.emptyList();
      private void ensureTransactionsIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          transactions_ = new java.util.ArrayList<org.hay.protos.core.hayTransaction.Transaction>(transactions_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          org.hay.protos.core.hayTransaction.Transaction, org.hay.protos.core.hayTransaction.Transaction.Builder, org.hay.protos.core.hayTransaction.TransactionOrBuilder> transactionsBuilder_;

      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public java.util.List<org.hay.protos.core.hayTransaction.Transaction> getTransactionsList() {
        if (transactionsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(transactions_);
        } else {
          return transactionsBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public int getTransactionsCount() {
        if (transactionsBuilder_ == null) {
          return transactions_.size();
        } else {
          return transactionsBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public org.hay.protos.core.hayTransaction.Transaction getTransactions(int index) {
        if (transactionsBuilder_ == null) {
          return transactions_.get(index);
        } else {
          return transactionsBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public Builder setTransactions(
          int index, org.hay.protos.core.hayTransaction.Transaction value) {
        if (transactionsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTransactionsIsMutable();
          transactions_.set(index, value);
          onChanged();
        } else {
          transactionsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public Builder setTransactions(
          int index, org.hay.protos.core.hayTransaction.Transaction.Builder builderForValue) {
        if (transactionsBuilder_ == null) {
          ensureTransactionsIsMutable();
          transactions_.set(index, builderForValue.build());
          onChanged();
        } else {
          transactionsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public Builder addTransactions(org.hay.protos.core.hayTransaction.Transaction value) {
        if (transactionsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTransactionsIsMutable();
          transactions_.add(value);
          onChanged();
        } else {
          transactionsBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public Builder addTransactions(
          int index, org.hay.protos.core.hayTransaction.Transaction value) {
        if (transactionsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureTransactionsIsMutable();
          transactions_.add(index, value);
          onChanged();
        } else {
          transactionsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public Builder addTransactions(
          org.hay.protos.core.hayTransaction.Transaction.Builder builderForValue) {
        if (transactionsBuilder_ == null) {
          ensureTransactionsIsMutable();
          transactions_.add(builderForValue.build());
          onChanged();
        } else {
          transactionsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public Builder addTransactions(
          int index, org.hay.protos.core.hayTransaction.Transaction.Builder builderForValue) {
        if (transactionsBuilder_ == null) {
          ensureTransactionsIsMutable();
          transactions_.add(index, builderForValue.build());
          onChanged();
        } else {
          transactionsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public Builder addAllTransactions(
          java.lang.Iterable<? extends org.hay.protos.core.hayTransaction.Transaction> values) {
        if (transactionsBuilder_ == null) {
          ensureTransactionsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, transactions_);
          onChanged();
        } else {
          transactionsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public Builder clearTransactions() {
        if (transactionsBuilder_ == null) {
          transactions_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          transactionsBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public Builder removeTransactions(int index) {
        if (transactionsBuilder_ == null) {
          ensureTransactionsIsMutable();
          transactions_.remove(index);
          onChanged();
        } else {
          transactionsBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public org.hay.protos.core.hayTransaction.Transaction.Builder getTransactionsBuilder(
          int index) {
        return getTransactionsFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public org.hay.protos.core.hayTransaction.TransactionOrBuilder getTransactionsOrBuilder(
          int index) {
        if (transactionsBuilder_ == null) {
          return transactions_.get(index);  } else {
          return transactionsBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public java.util.List<? extends org.hay.protos.core.hayTransaction.TransactionOrBuilder>
           getTransactionsOrBuilderList() {
        if (transactionsBuilder_ != null) {
          return transactionsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(transactions_);
        }
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public org.hay.protos.core.hayTransaction.Transaction.Builder addTransactionsBuilder() {
        return getTransactionsFieldBuilder().addBuilder(
            org.hay.protos.core.hayTransaction.Transaction.getDefaultInstance());
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public org.hay.protos.core.hayTransaction.Transaction.Builder addTransactionsBuilder(
          int index) {
        return getTransactionsFieldBuilder().addBuilder(
            index, org.hay.protos.core.hayTransaction.Transaction.getDefaultInstance());
      }
      /**
       * <code>repeated .protos.Transaction transactions = 1;</code>
       */
      public java.util.List<org.hay.protos.core.hayTransaction.Transaction.Builder>
           getTransactionsBuilderList() {
        return getTransactionsFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          org.hay.protos.core.hayTransaction.Transaction, org.hay.protos.core.hayTransaction.Transaction.Builder, org.hay.protos.core.hayTransaction.TransactionOrBuilder>
          getTransactionsFieldBuilder() {
        if (transactionsBuilder_ == null) {
          transactionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              org.hay.protos.core.hayTransaction.Transaction, org.hay.protos.core.hayTransaction.Transaction.Builder, org.hay.protos.core.hayTransaction.TransactionOrBuilder>(
                  transactions_,
                  ((bitField0_ & 0x00000001) == 0x00000001),
                  getParentForChildren(),
                  isClean());
          transactions_ = null;
        }
        return transactionsBuilder_;
      }

      private org.hay.protos.core.hayBlockHeader.BlockHeader blockHeader_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          org.hay.protos.core.hayBlockHeader.BlockHeader, org.hay.protos.core.hayBlockHeader.BlockHeader.Builder, org.hay.protos.core.hayBlockHeader.BlockHeaderOrBuilder> blockHeaderBuilder_;
      /**
       * <code>.protos.BlockHeader blockHeader = 2;</code>
       */
      public boolean hasBlockHeader() {
        return blockHeaderBuilder_ != null || blockHeader_ != null;
      }
      /**
       * <code>.protos.BlockHeader blockHeader = 2;</code>
       */
      public org.hay.protos.core.hayBlockHeader.BlockHeader getBlockHeader() {
        if (blockHeaderBuilder_ == null) {
          return blockHeader_ == null ? org.hay.protos.core.hayBlockHeader.BlockHeader.getDefaultInstance() : blockHeader_;
        } else {
          return blockHeaderBuilder_.getMessage();
        }
      }
      /**
       * <code>.protos.BlockHeader blockHeader = 2;</code>
       */
      public Builder setBlockHeader(org.hay.protos.core.hayBlockHeader.BlockHeader value) {
        if (blockHeaderBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          blockHeader_ = value;
          onChanged();
        } else {
          blockHeaderBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.protos.BlockHeader blockHeader = 2;</code>
       */
      public Builder setBlockHeader(
          org.hay.protos.core.hayBlockHeader.BlockHeader.Builder builderForValue) {
        if (blockHeaderBuilder_ == null) {
          blockHeader_ = builderForValue.build();
          onChanged();
        } else {
          blockHeaderBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.protos.BlockHeader blockHeader = 2;</code>
       */
      public Builder mergeBlockHeader(org.hay.protos.core.hayBlockHeader.BlockHeader value) {
        if (blockHeaderBuilder_ == null) {
          if (blockHeader_ != null) {
            blockHeader_ =
              org.hay.protos.core.hayBlockHeader.BlockHeader.newBuilder(blockHeader_).mergeFrom(value).buildPartial();
          } else {
            blockHeader_ = value;
          }
          onChanged();
        } else {
          blockHeaderBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.protos.BlockHeader blockHeader = 2;</code>
       */
      public Builder clearBlockHeader() {
        if (blockHeaderBuilder_ == null) {
          blockHeader_ = null;
          onChanged();
        } else {
          blockHeader_ = null;
          blockHeaderBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.protos.BlockHeader blockHeader = 2;</code>
       */
      public org.hay.protos.core.hayBlockHeader.BlockHeader.Builder getBlockHeaderBuilder() {
        
        onChanged();
        return getBlockHeaderFieldBuilder().getBuilder();
      }
      /**
       * <code>.protos.BlockHeader blockHeader = 2;</code>
       */
      public org.hay.protos.core.hayBlockHeader.BlockHeaderOrBuilder getBlockHeaderOrBuilder() {
        if (blockHeaderBuilder_ != null) {
          return blockHeaderBuilder_.getMessageOrBuilder();
        } else {
          return blockHeader_ == null ?
              org.hay.protos.core.hayBlockHeader.BlockHeader.getDefaultInstance() : blockHeader_;
        }
      }
      /**
       * <code>.protos.BlockHeader blockHeader = 2;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          org.hay.protos.core.hayBlockHeader.BlockHeader, org.hay.protos.core.hayBlockHeader.BlockHeader.Builder, org.hay.protos.core.hayBlockHeader.BlockHeaderOrBuilder>
          getBlockHeaderFieldBuilder() {
        if (blockHeaderBuilder_ == null) {
          blockHeaderBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              org.hay.protos.core.hayBlockHeader.BlockHeader, org.hay.protos.core.hayBlockHeader.BlockHeader.Builder, org.hay.protos.core.hayBlockHeader.BlockHeaderOrBuilder>(
                  getBlockHeader(),
                  getParentForChildren(),
                  isClean());
          blockHeader_ = null;
        }
        return blockHeaderBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:protos.Block)
    }

    // @@protoc_insertion_point(class_scope:protos.Block)
    private static final org.hay.protos.core.hayBlock.Block DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.hay.protos.core.hayBlock.Block();
    }

    public static org.hay.protos.core.hayBlock.Block getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Block>
        PARSER = new com.google.protobuf.AbstractParser<Block>() {
      public Block parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Block(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Block> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Block> getParserForType() {
      return PARSER;
    }

    public org.hay.protos.core.hayBlock.Block getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protos_Block_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protos_Block_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024core/hayBlock.proto\022\006protos\032\032core/Tro" +
      "nTransaction.proto\032\032core/hayBlockHeader" +
      ".proto\"\\\n\005Block\022)\n\014transactions\030\001 \003(\0132\023." +
      "protos.Transaction\022(\n\013blockHeader\030\002 \001(\0132" +
      "\023.protos.BlockHeaderB!\n\024org.hay.protos." +
      "coreB\thayBlockb\006proto3"
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
          org.hay.protos.core.hayTransaction.getDescriptor(),
          org.hay.protos.core.hayBlockHeader.getDescriptor(),
        }, assigner);
    internal_static_protos_Block_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_protos_Block_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protos_Block_descriptor,
        new java.lang.String[] { "Transactions", "BlockHeader", });
    org.hay.protos.core.hayTransaction.getDescriptor();
    org.hay.protos.core.hayBlockHeader.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
