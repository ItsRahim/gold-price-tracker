// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: price.proto
// Protobuf Java Version: 4.29.1

package messages;

/**
 * Protobuf type {@code messages.PriceSnapshot}
 */
public final class PriceSnapshot extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:messages.PriceSnapshot)
    PriceSnapshotOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 1,
      /* suffix= */ "",
      PriceSnapshot.class.getName());
  }
  // Use PriceSnapshot.newBuilder() to construct.
  private PriceSnapshot(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private PriceSnapshot() {
    source_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return messages.Price.internal_static_messages_PriceSnapshot_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages.Price.internal_static_messages_PriceSnapshot_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.PriceSnapshot.class, messages.PriceSnapshot.Builder.class);
  }

  private int bitField0_;
  public static final int SOURCE_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object source_ = "";
  /**
   * <code>string source = 1;</code>
   * @return The source.
   */
  @java.lang.Override
  public java.lang.String getSource() {
    java.lang.Object ref = source_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      source_ = s;
      return s;
    }
  }
  /**
   * <code>string source = 1;</code>
   * @return The bytes for source.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSourceBytes() {
    java.lang.Object ref = source_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      source_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATETIME_FIELD_NUMBER = 2;
  private com.google.protobuf.Timestamp datetime_;
  /**
   * <code>.google.protobuf.Timestamp datetime = 2;</code>
   * @return Whether the datetime field is set.
   */
  @java.lang.Override
  public boolean hasDatetime() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.google.protobuf.Timestamp datetime = 2;</code>
   * @return The datetime.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getDatetime() {
    return datetime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : datetime_;
  }
  /**
   * <code>.google.protobuf.Timestamp datetime = 2;</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getDatetimeOrBuilder() {
    return datetime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : datetime_;
  }

  public static final int PRICE_FIELD_NUMBER = 3;
  private float price_ = 0F;
  /**
   * <code>float price = 3;</code>
   * @return The price.
   */
  @java.lang.Override
  public float getPrice() {
    return price_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(source_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, source_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(2, getDatetime());
    }
    if (java.lang.Float.floatToRawIntBits(price_) != 0) {
      output.writeFloat(3, price_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(source_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, source_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getDatetime());
    }
    if (java.lang.Float.floatToRawIntBits(price_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(3, price_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof messages.PriceSnapshot)) {
      return super.equals(obj);
    }
    messages.PriceSnapshot other = (messages.PriceSnapshot) obj;

    if (!getSource()
        .equals(other.getSource())) return false;
    if (hasDatetime() != other.hasDatetime()) return false;
    if (hasDatetime()) {
      if (!getDatetime()
          .equals(other.getDatetime())) return false;
    }
    if (java.lang.Float.floatToIntBits(getPrice())
        != java.lang.Float.floatToIntBits(
            other.getPrice())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SOURCE_FIELD_NUMBER;
    hash = (53 * hash) + getSource().hashCode();
    if (hasDatetime()) {
      hash = (37 * hash) + DATETIME_FIELD_NUMBER;
      hash = (53 * hash) + getDatetime().hashCode();
    }
    hash = (37 * hash) + PRICE_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getPrice());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static messages.PriceSnapshot parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.PriceSnapshot parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.PriceSnapshot parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.PriceSnapshot parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.PriceSnapshot parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.PriceSnapshot parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.PriceSnapshot parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static messages.PriceSnapshot parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static messages.PriceSnapshot parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static messages.PriceSnapshot parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static messages.PriceSnapshot parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static messages.PriceSnapshot parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(messages.PriceSnapshot prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code messages.PriceSnapshot}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:messages.PriceSnapshot)
      messages.PriceSnapshotOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages.Price.internal_static_messages_PriceSnapshot_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages.Price.internal_static_messages_PriceSnapshot_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.PriceSnapshot.class, messages.PriceSnapshot.Builder.class);
    }

    // Construct using messages.PriceSnapshot.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage
              .alwaysUseFieldBuilders) {
        getDatetimeFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      source_ = "";
      datetime_ = null;
      if (datetimeBuilder_ != null) {
        datetimeBuilder_.dispose();
        datetimeBuilder_ = null;
      }
      price_ = 0F;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages.Price.internal_static_messages_PriceSnapshot_descriptor;
    }

    @java.lang.Override
    public messages.PriceSnapshot getDefaultInstanceForType() {
      return messages.PriceSnapshot.getDefaultInstance();
    }

    @java.lang.Override
    public messages.PriceSnapshot build() {
      messages.PriceSnapshot result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public messages.PriceSnapshot buildPartial() {
      messages.PriceSnapshot result = new messages.PriceSnapshot(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(messages.PriceSnapshot result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.source_ = source_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.datetime_ = datetimeBuilder_ == null
            ? datetime_
            : datetimeBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.price_ = price_;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.PriceSnapshot) {
        return mergeFrom((messages.PriceSnapshot)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.PriceSnapshot other) {
      if (other == messages.PriceSnapshot.getDefaultInstance()) return this;
      if (!other.getSource().isEmpty()) {
        source_ = other.source_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasDatetime()) {
        mergeDatetime(other.getDatetime());
      }
      if (other.getPrice() != 0F) {
        setPrice(other.getPrice());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              source_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getDatetimeFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 29: {
              price_ = input.readFloat();
              bitField0_ |= 0x00000004;
              break;
            } // case 29
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object source_ = "";
    /**
     * <code>string source = 1;</code>
     * @return The source.
     */
    public java.lang.String getSource() {
      java.lang.Object ref = source_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        source_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string source = 1;</code>
     * @return The bytes for source.
     */
    public com.google.protobuf.ByteString
        getSourceBytes() {
      java.lang.Object ref = source_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        source_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string source = 1;</code>
     * @param value The source to set.
     * @return This builder for chaining.
     */
    public Builder setSource(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      source_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string source = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSource() {
      source_ = getDefaultInstance().getSource();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string source = 1;</code>
     * @param value The bytes for source to set.
     * @return This builder for chaining.
     */
    public Builder setSourceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      source_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private com.google.protobuf.Timestamp datetime_;
    private com.google.protobuf.SingleFieldBuilder<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> datetimeBuilder_;
    /**
     * <code>.google.protobuf.Timestamp datetime = 2;</code>
     * @return Whether the datetime field is set.
     */
    public boolean hasDatetime() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.google.protobuf.Timestamp datetime = 2;</code>
     * @return The datetime.
     */
    public com.google.protobuf.Timestamp getDatetime() {
      if (datetimeBuilder_ == null) {
        return datetime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : datetime_;
      } else {
        return datetimeBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp datetime = 2;</code>
     */
    public Builder setDatetime(com.google.protobuf.Timestamp value) {
      if (datetimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        datetime_ = value;
      } else {
        datetimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp datetime = 2;</code>
     */
    public Builder setDatetime(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (datetimeBuilder_ == null) {
        datetime_ = builderForValue.build();
      } else {
        datetimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp datetime = 2;</code>
     */
    public Builder mergeDatetime(com.google.protobuf.Timestamp value) {
      if (datetimeBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          datetime_ != null &&
          datetime_ != com.google.protobuf.Timestamp.getDefaultInstance()) {
          getDatetimeBuilder().mergeFrom(value);
        } else {
          datetime_ = value;
        }
      } else {
        datetimeBuilder_.mergeFrom(value);
      }
      if (datetime_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp datetime = 2;</code>
     */
    public Builder clearDatetime() {
      bitField0_ = (bitField0_ & ~0x00000002);
      datetime_ = null;
      if (datetimeBuilder_ != null) {
        datetimeBuilder_.dispose();
        datetimeBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp datetime = 2;</code>
     */
    public com.google.protobuf.Timestamp.Builder getDatetimeBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getDatetimeFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp datetime = 2;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getDatetimeOrBuilder() {
      if (datetimeBuilder_ != null) {
        return datetimeBuilder_.getMessageOrBuilder();
      } else {
        return datetime_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : datetime_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp datetime = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getDatetimeFieldBuilder() {
      if (datetimeBuilder_ == null) {
        datetimeBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getDatetime(),
                getParentForChildren(),
                isClean());
        datetime_ = null;
      }
      return datetimeBuilder_;
    }

    private float price_ ;
    /**
     * <code>float price = 3;</code>
     * @return The price.
     */
    @java.lang.Override
    public float getPrice() {
      return price_;
    }
    /**
     * <code>float price = 3;</code>
     * @param value The price to set.
     * @return This builder for chaining.
     */
    public Builder setPrice(float value) {

      price_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>float price = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrice() {
      bitField0_ = (bitField0_ & ~0x00000004);
      price_ = 0F;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:messages.PriceSnapshot)
  }

  // @@protoc_insertion_point(class_scope:messages.PriceSnapshot)
  private static final messages.PriceSnapshot DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new messages.PriceSnapshot();
  }

  public static messages.PriceSnapshot getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PriceSnapshot>
      PARSER = new com.google.protobuf.AbstractParser<PriceSnapshot>() {
    @java.lang.Override
    public PriceSnapshot parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<PriceSnapshot> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PriceSnapshot> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public messages.PriceSnapshot getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
