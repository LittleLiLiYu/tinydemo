// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: openloan.proto

package cn.sunline.proto;

public final class Openloan {
  private Openloan() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface openloanOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.openloan)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string loanAmt = 1;</code>
     */
    java.lang.String getLoanAmt();
    /**
     * <code>string loanAmt = 1;</code>
     */
    com.google.protobuf.ByteString
        getLoanAmtBytes();

    /**
     * <code>string certifyNo = 2;</code>
     */
    java.lang.String getCertifyNo();
    /**
     * <code>string certifyNo = 2;</code>
     */
    com.google.protobuf.ByteString
        getCertifyNoBytes();

    /**
     * <code>string startInstDate = 3;</code>
     */
    java.lang.String getStartInstDate();
    /**
     * <code>string startInstDate = 3;</code>
     */
    com.google.protobuf.ByteString
        getStartInstDateBytes();
  }
  /**
   * Protobuf type {@code proto.openloan}
   */
  public  static final class openloan extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.openloan)
      openloanOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use openloan.newBuilder() to construct.
    private openloan(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private openloan() {
      loanAmt_ = "";
      certifyNo_ = "";
      startInstDate_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private openloan(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              loanAmt_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              certifyNo_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              startInstDate_ = s;
              break;
            }
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.sunline.proto.Openloan.internal_static_proto_openloan_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.sunline.proto.Openloan.internal_static_proto_openloan_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.sunline.proto.Openloan.openloan.class, cn.sunline.proto.Openloan.openloan.Builder.class);
    }

    public static final int LOANAMT_FIELD_NUMBER = 1;
    private volatile java.lang.Object loanAmt_;
    /**
     * <code>string loanAmt = 1;</code>
     */
    public java.lang.String getLoanAmt() {
      java.lang.Object ref = loanAmt_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        loanAmt_ = s;
        return s;
      }
    }
    /**
     * <code>string loanAmt = 1;</code>
     */
    public com.google.protobuf.ByteString
        getLoanAmtBytes() {
      java.lang.Object ref = loanAmt_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        loanAmt_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CERTIFYNO_FIELD_NUMBER = 2;
    private volatile java.lang.Object certifyNo_;
    /**
     * <code>string certifyNo = 2;</code>
     */
    public java.lang.String getCertifyNo() {
      java.lang.Object ref = certifyNo_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        certifyNo_ = s;
        return s;
      }
    }
    /**
     * <code>string certifyNo = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCertifyNoBytes() {
      java.lang.Object ref = certifyNo_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        certifyNo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STARTINSTDATE_FIELD_NUMBER = 3;
    private volatile java.lang.Object startInstDate_;
    /**
     * <code>string startInstDate = 3;</code>
     */
    public java.lang.String getStartInstDate() {
      java.lang.Object ref = startInstDate_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        startInstDate_ = s;
        return s;
      }
    }
    /**
     * <code>string startInstDate = 3;</code>
     */
    public com.google.protobuf.ByteString
        getStartInstDateBytes() {
      java.lang.Object ref = startInstDate_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        startInstDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getLoanAmtBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, loanAmt_);
      }
      if (!getCertifyNoBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, certifyNo_);
      }
      if (!getStartInstDateBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, startInstDate_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getLoanAmtBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, loanAmt_);
      }
      if (!getCertifyNoBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, certifyNo_);
      }
      if (!getStartInstDateBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, startInstDate_);
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
      if (!(obj instanceof cn.sunline.proto.Openloan.openloan)) {
        return super.equals(obj);
      }
      cn.sunline.proto.Openloan.openloan other = (cn.sunline.proto.Openloan.openloan) obj;

      boolean result = true;
      result = result && getLoanAmt()
          .equals(other.getLoanAmt());
      result = result && getCertifyNo()
          .equals(other.getCertifyNo());
      result = result && getStartInstDate()
          .equals(other.getStartInstDate());
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
      hash = (37 * hash) + LOANAMT_FIELD_NUMBER;
      hash = (53 * hash) + getLoanAmt().hashCode();
      hash = (37 * hash) + CERTIFYNO_FIELD_NUMBER;
      hash = (53 * hash) + getCertifyNo().hashCode();
      hash = (37 * hash) + STARTINSTDATE_FIELD_NUMBER;
      hash = (53 * hash) + getStartInstDate().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static cn.sunline.proto.Openloan.openloan parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cn.sunline.proto.Openloan.openloan parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cn.sunline.proto.Openloan.openloan parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cn.sunline.proto.Openloan.openloan parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cn.sunline.proto.Openloan.openloan parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cn.sunline.proto.Openloan.openloan parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cn.sunline.proto.Openloan.openloan parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static cn.sunline.proto.Openloan.openloan parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static cn.sunline.proto.Openloan.openloan parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static cn.sunline.proto.Openloan.openloan parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static cn.sunline.proto.Openloan.openloan parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static cn.sunline.proto.Openloan.openloan parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(cn.sunline.proto.Openloan.openloan prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
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
     * Protobuf type {@code proto.openloan}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.openloan)
        cn.sunline.proto.Openloan.openloanOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return cn.sunline.proto.Openloan.internal_static_proto_openloan_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return cn.sunline.proto.Openloan.internal_static_proto_openloan_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                cn.sunline.proto.Openloan.openloan.class, cn.sunline.proto.Openloan.openloan.Builder.class);
      }

      // Construct using cn.sunline.proto.Openloan.openloan.newBuilder()
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
      @java.lang.Override
      public Builder clear() {
        super.clear();
        loanAmt_ = "";

        certifyNo_ = "";

        startInstDate_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return cn.sunline.proto.Openloan.internal_static_proto_openloan_descriptor;
      }

      @java.lang.Override
      public cn.sunline.proto.Openloan.openloan getDefaultInstanceForType() {
        return cn.sunline.proto.Openloan.openloan.getDefaultInstance();
      }

      @java.lang.Override
      public cn.sunline.proto.Openloan.openloan build() {
        cn.sunline.proto.Openloan.openloan result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public cn.sunline.proto.Openloan.openloan buildPartial() {
        cn.sunline.proto.Openloan.openloan result = new cn.sunline.proto.Openloan.openloan(this);
        result.loanAmt_ = loanAmt_;
        result.certifyNo_ = certifyNo_;
        result.startInstDate_ = startInstDate_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return (Builder) super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof cn.sunline.proto.Openloan.openloan) {
          return mergeFrom((cn.sunline.proto.Openloan.openloan)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(cn.sunline.proto.Openloan.openloan other) {
        if (other == cn.sunline.proto.Openloan.openloan.getDefaultInstance()) return this;
        if (!other.getLoanAmt().isEmpty()) {
          loanAmt_ = other.loanAmt_;
          onChanged();
        }
        if (!other.getCertifyNo().isEmpty()) {
          certifyNo_ = other.certifyNo_;
          onChanged();
        }
        if (!other.getStartInstDate().isEmpty()) {
          startInstDate_ = other.startInstDate_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
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
        cn.sunline.proto.Openloan.openloan parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (cn.sunline.proto.Openloan.openloan) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object loanAmt_ = "";
      /**
       * <code>string loanAmt = 1;</code>
       */
      public java.lang.String getLoanAmt() {
        java.lang.Object ref = loanAmt_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          loanAmt_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string loanAmt = 1;</code>
       */
      public com.google.protobuf.ByteString
          getLoanAmtBytes() {
        java.lang.Object ref = loanAmt_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          loanAmt_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string loanAmt = 1;</code>
       */
      public Builder setLoanAmt(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        loanAmt_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string loanAmt = 1;</code>
       */
      public Builder clearLoanAmt() {
        
        loanAmt_ = getDefaultInstance().getLoanAmt();
        onChanged();
        return this;
      }
      /**
       * <code>string loanAmt = 1;</code>
       */
      public Builder setLoanAmtBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        loanAmt_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object certifyNo_ = "";
      /**
       * <code>string certifyNo = 2;</code>
       */
      public java.lang.String getCertifyNo() {
        java.lang.Object ref = certifyNo_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          certifyNo_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string certifyNo = 2;</code>
       */
      public com.google.protobuf.ByteString
          getCertifyNoBytes() {
        java.lang.Object ref = certifyNo_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          certifyNo_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string certifyNo = 2;</code>
       */
      public Builder setCertifyNo(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        certifyNo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string certifyNo = 2;</code>
       */
      public Builder clearCertifyNo() {
        
        certifyNo_ = getDefaultInstance().getCertifyNo();
        onChanged();
        return this;
      }
      /**
       * <code>string certifyNo = 2;</code>
       */
      public Builder setCertifyNoBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        certifyNo_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object startInstDate_ = "";
      /**
       * <code>string startInstDate = 3;</code>
       */
      public java.lang.String getStartInstDate() {
        java.lang.Object ref = startInstDate_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          startInstDate_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string startInstDate = 3;</code>
       */
      public com.google.protobuf.ByteString
          getStartInstDateBytes() {
        java.lang.Object ref = startInstDate_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          startInstDate_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string startInstDate = 3;</code>
       */
      public Builder setStartInstDate(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        startInstDate_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string startInstDate = 3;</code>
       */
      public Builder clearStartInstDate() {
        
        startInstDate_ = getDefaultInstance().getStartInstDate();
        onChanged();
        return this;
      }
      /**
       * <code>string startInstDate = 3;</code>
       */
      public Builder setStartInstDateBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        startInstDate_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:proto.openloan)
    }

    // @@protoc_insertion_point(class_scope:proto.openloan)
    private static final cn.sunline.proto.Openloan.openloan DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new cn.sunline.proto.Openloan.openloan();
    }

    public static cn.sunline.proto.Openloan.openloan getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<openloan>
        PARSER = new com.google.protobuf.AbstractParser<openloan>() {
      @java.lang.Override
      public openloan parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new openloan(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<openloan> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<openloan> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public cn.sunline.proto.Openloan.openloan getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_openloan_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_openloan_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016openloan.proto\022\005proto\"E\n\010openloan\022\017\n\007l" +
      "oanAmt\030\001 \001(\t\022\021\n\tcertifyNo\030\002 \001(\t\022\025\n\rstart" +
      "InstDate\030\003 \001(\tB\022\n\020cn.sunline.protob\006prot" +
      "o3"
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
    internal_static_proto_openloan_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_openloan_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_openloan_descriptor,
        new java.lang.String[] { "LoanAmt", "CertifyNo", "StartInstDate", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
