package com.mots.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.*;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * IM收到有变化的通知消息
 * 这里由于和业务关系不大，不在这里定义，定义在didi_protocol.proto
 * message MessageSvrNotification {
 * repeated IMSessionChanged sessions = 1;
 * repeated IMMessageArrived messages = 2;
 * }
 * 司机信息
 */
public final class DriverInfo extends Message {

    public static final String DEFAULT_DRIVER_NAME = "";
    public static final String DEFAULT_DRIVER_CARD = "";
    public static final String DEFAULT_DRIVER_COMPANY = "";
    public static final String DEFAULT_DRIVER_HEADPIC = "";
    public static final String DEFAULT_DRIVER_PHONE = "";
    public static final Long DEFAULT_DRIVER_ID = 0L;
    public static final String DEFAULT_CAR_TYPE = "";
    public static final Integer DEFAULT_CNT_ORDER = 0;
    public static final Integer DEFAULT_CNT_POSITIVE = 0;
    public static final Integer DEFAULT_LEVEL = 0;
    public static final Float DEFAULT_LEVEL_NEW = 0F;
    public static final Integer DEFAULT_IS_PROTECT = 0;
    public static final Integer DEFAULT_IS_TIMEOUT = 0;

    @ProtoField(tag = 1, type = STRING, label = REQUIRED)
    public final String driver_name;

    @ProtoField(tag = 2, type = STRING, label = REQUIRED)
    public final String driver_card;

    @ProtoField(tag = 3, type = STRING, label = REQUIRED)
    public final String driver_company;

    @ProtoField(tag = 4, type = STRING, label = REQUIRED)
    public final String driver_headPic;

    @ProtoField(tag = 5, type = STRING, label = REQUIRED)
    public final String driver_phone;

    @ProtoField(tag = 6, type = UINT64)
    public final Long driver_id;

    @ProtoField(tag = 7, type = STRING)
    public final String car_type;

    @ProtoField(tag = 8, type = INT32)
    public final Integer cnt_order;

    @ProtoField(tag = 9, type = INT32)
    public final Integer cnt_positive;

    @ProtoField(tag = 10, type = INT32)
    public final Integer level;

    @ProtoField(tag = 11, type = FLOAT)
    public final Float level_new;

    /**
     * 0真实手机号, 1虚拟手机号
     */
    @ProtoField(tag = 12, type = INT32)
    public final Integer is_protect;

    /**
     * 0未超时可以拨打 1超时联系客服
     */
    @ProtoField(tag = 13, type = INT32)
    public final Integer is_timeout;

    public DriverInfo(String driver_name, String driver_card, String driver_company, String driver_headPic, String driver_phone, Long driver_id, String car_type, Integer cnt_order, Integer cnt_positive, Integer level, Float level_new, Integer is_protect, Integer is_timeout) {
        this.driver_name = driver_name;
        this.driver_card = driver_card;
        this.driver_company = driver_company;
        this.driver_headPic = driver_headPic;
        this.driver_phone = driver_phone;
        this.driver_id = driver_id;
        this.car_type = car_type;
        this.cnt_order = cnt_order;
        this.cnt_positive = cnt_positive;
        this.level = level;
        this.level_new = level_new;
        this.is_protect = is_protect;
        this.is_timeout = is_timeout;
    }

    private DriverInfo(Builder builder) {
        this(builder.driver_name, builder.driver_card, builder.driver_company, builder.driver_headPic, builder.driver_phone, builder.driver_id, builder.car_type, builder.cnt_order, builder.cnt_positive, builder.level, builder.level_new, builder.is_protect, builder.is_timeout);
        setBuilder(builder);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof DriverInfo)) return false;
        DriverInfo o = (DriverInfo) other;
        return equals(driver_name, o.driver_name)
                && equals(driver_card, o.driver_card)
                && equals(driver_company, o.driver_company)
                && equals(driver_headPic, o.driver_headPic)
                && equals(driver_phone, o.driver_phone)
                && equals(driver_id, o.driver_id)
                && equals(car_type, o.car_type)
                && equals(cnt_order, o.cnt_order)
                && equals(cnt_positive, o.cnt_positive)
                && equals(level, o.level)
                && equals(level_new, o.level_new)
                && equals(is_protect, o.is_protect)
                && equals(is_timeout, o.is_timeout);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = driver_name != null ? driver_name.hashCode() : 0;
            result = result * 37 + (driver_card != null ? driver_card.hashCode() : 0);
            result = result * 37 + (driver_company != null ? driver_company.hashCode() : 0);
            result = result * 37 + (driver_headPic != null ? driver_headPic.hashCode() : 0);
            result = result * 37 + (driver_phone != null ? driver_phone.hashCode() : 0);
            result = result * 37 + (driver_id != null ? driver_id.hashCode() : 0);
            result = result * 37 + (car_type != null ? car_type.hashCode() : 0);
            result = result * 37 + (cnt_order != null ? cnt_order.hashCode() : 0);
            result = result * 37 + (cnt_positive != null ? cnt_positive.hashCode() : 0);
            result = result * 37 + (level != null ? level.hashCode() : 0);
            result = result * 37 + (level_new != null ? level_new.hashCode() : 0);
            result = result * 37 + (is_protect != null ? is_protect.hashCode() : 0);
            result = result * 37 + (is_timeout != null ? is_timeout.hashCode() : 0);
            hashCode = result;
        }
        return result;
    }

    public static final class Builder extends Message.Builder<DriverInfo> {

        public String driver_name;
        public String driver_card;
        public String driver_company;
        public String driver_headPic;
        public String driver_phone;
        public Long driver_id;
        public String car_type;
        public Integer cnt_order;
        public Integer cnt_positive;
        public Integer level;
        public Float level_new;
        public Integer is_protect;
        public Integer is_timeout;

        public Builder() {
        }

        public Builder(DriverInfo message) {
            super(message);
            if (message == null) return;
            this.driver_name = message.driver_name;
            this.driver_card = message.driver_card;
            this.driver_company = message.driver_company;
            this.driver_headPic = message.driver_headPic;
            this.driver_phone = message.driver_phone;
            this.driver_id = message.driver_id;
            this.car_type = message.car_type;
            this.cnt_order = message.cnt_order;
            this.cnt_positive = message.cnt_positive;
            this.level = message.level;
            this.level_new = message.level_new;
            this.is_protect = message.is_protect;
            this.is_timeout = message.is_timeout;
        }

        public Builder driver_name(String driver_name) {
            this.driver_name = driver_name;
            return this;
        }

        public Builder driver_card(String driver_card) {
            this.driver_card = driver_card;
            return this;
        }

        public Builder driver_company(String driver_company) {
            this.driver_company = driver_company;
            return this;
        }

        public Builder driver_headPic(String driver_headPic) {
            this.driver_headPic = driver_headPic;
            return this;
        }

        public Builder driver_phone(String driver_phone) {
            this.driver_phone = driver_phone;
            return this;
        }

        public Builder driver_id(Long driver_id) {
            this.driver_id = driver_id;
            return this;
        }

        public Builder car_type(String car_type) {
            this.car_type = car_type;
            return this;
        }

        public Builder cnt_order(Integer cnt_order) {
            this.cnt_order = cnt_order;
            return this;
        }

        public Builder cnt_positive(Integer cnt_positive) {
            this.cnt_positive = cnt_positive;
            return this;
        }

        public Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public Builder level_new(Float level_new) {
            this.level_new = level_new;
            return this;
        }

        /**
         * 0真实手机号, 1虚拟手机号
         */
        public Builder is_protect(Integer is_protect) {
            this.is_protect = is_protect;
            return this;
        }

        /**
         * 0未超时可以拨打 1超时联系客服
         */
        public Builder is_timeout(Integer is_timeout) {
            this.is_timeout = is_timeout;
            return this;
        }

        @Override
        public DriverInfo build() {
            checkRequiredFields();
            return new DriverInfo(this);
        }
    }
}
