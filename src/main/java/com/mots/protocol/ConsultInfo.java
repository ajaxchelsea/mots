package com.mots.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.STRING;

public final class ConsultInfo extends Message {

    public static final String DEFAULT_CONSULT_MIN = "";
    public static final String DEFAULT_DRIVER_TIPS = "";
    public static final String DEFAULT_SYSTEM_TIPS = "";

    /**
     * 协商信息
     * 协商时间，分钟为单位
     */
    @ProtoField(tag = 1, type = STRING)
    public final String consult_min;

    /**
     * 我承诺20分钟到达上车地点接您，您接受么？
     */
    @ProtoField(tag = 2, type = STRING)
    public final String driver_tips;

    /**
     * 20秒后司机有可能取消，请尽快确认。
     */
    @ProtoField(tag = 3, type = STRING)
    public final String system_tips;

    public ConsultInfo(String consult_min, String driver_tips, String system_tips) {
        this.consult_min = consult_min;
        this.driver_tips = driver_tips;
        this.system_tips = system_tips;
    }

    private ConsultInfo(Builder builder) {
        this(builder.consult_min, builder.driver_tips, builder.system_tips);
        setBuilder(builder);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof ConsultInfo)) return false;
        ConsultInfo o = (ConsultInfo) other;
        return equals(consult_min, o.consult_min)
                && equals(driver_tips, o.driver_tips)
                && equals(system_tips, o.system_tips);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = consult_min != null ? consult_min.hashCode() : 0;
            result = result * 37 + (driver_tips != null ? driver_tips.hashCode() : 0);
            result = result * 37 + (system_tips != null ? system_tips.hashCode() : 0);
            hashCode = result;
        }
        return result;
    }

    public static final class Builder extends Message.Builder<ConsultInfo> {

        public String consult_min;
        public String driver_tips;
        public String system_tips;

        public Builder() {
        }

        public Builder(ConsultInfo message) {
            super(message);
            if (message == null) return;
            this.consult_min = message.consult_min;
            this.driver_tips = message.driver_tips;
            this.system_tips = message.system_tips;
        }

        /**
         * 协商信息
         * 协商时间，分钟为单位
         */
        public Builder consult_min(String consult_min) {
            this.consult_min = consult_min;
            return this;
        }

        /**
         * 我承诺20分钟到达上车地点接您，您接受么？
         */
        public Builder driver_tips(String driver_tips) {
            this.driver_tips = driver_tips;
            return this;
        }

        /**
         * 20秒后司机有可能取消，请尽快确认。
         */
        public Builder system_tips(String system_tips) {
            this.system_tips = system_tips;
            return this;
        }

        @Override
        public ConsultInfo build() {
            return new ConsultInfo(this);
        }
    }
}
