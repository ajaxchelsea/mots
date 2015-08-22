package com.mots.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.FLOAT;
import static com.squareup.wire.Message.Datatype.INT32;

public final class DriverPos extends Message {

    public static final Integer DEFAULT_ARRIVED_TIME = 0;
    public static final Float DEFAULT_DISTANCE = 0F;
    public static final Integer DEFAULT_DISTANCE_ENABLED = 0;

    @ProtoField(tag = 1)
    public final Coordinate pos;

    @ProtoField(tag = 2, type = INT32)
    public final Integer arrived_time;

    @ProtoField(tag = 3, type = FLOAT)
    public final Float distance;

    @ProtoField(tag = 4, type = INT32)
    public final Integer distance_enabled;

    public DriverPos(Coordinate pos, Integer arrived_time, Float distance, Integer distance_enabled) {
        this.pos = pos;
        this.arrived_time = arrived_time;
        this.distance = distance;
        this.distance_enabled = distance_enabled;
    }

    private DriverPos(Builder builder) {
        this(builder.pos, builder.arrived_time, builder.distance, builder.distance_enabled);
        setBuilder(builder);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof DriverPos)) return false;
        DriverPos o = (DriverPos) other;
        return equals(pos, o.pos)
                && equals(arrived_time, o.arrived_time)
                && equals(distance, o.distance)
                && equals(distance_enabled, o.distance_enabled);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = pos != null ? pos.hashCode() : 0;
            result = result * 37 + (arrived_time != null ? arrived_time.hashCode() : 0);
            result = result * 37 + (distance != null ? distance.hashCode() : 0);
            result = result * 37 + (distance_enabled != null ? distance_enabled.hashCode() : 0);
            hashCode = result;
        }
        return result;
    }

    public static final class Builder extends Message.Builder<DriverPos> {

        public Coordinate pos;
        public Integer arrived_time;
        public Float distance;
        public Integer distance_enabled;

        public Builder() {
        }

        public Builder(DriverPos message) {
            super(message);
            if (message == null) return;
            this.pos = message.pos;
            this.arrived_time = message.arrived_time;
            this.distance = message.distance;
            this.distance_enabled = message.distance_enabled;
        }

        public Builder pos(Coordinate pos) {
            this.pos = pos;
            return this;
        }

        public Builder arrived_time(Integer arrived_time) {
            this.arrived_time = arrived_time;
            return this;
        }

        public Builder distance(Float distance) {
            this.distance = distance;
            return this;
        }

        public Builder distance_enabled(Integer distance_enabled) {
            this.distance_enabled = distance_enabled;
            return this;
        }

        @Override
        public DriverPos build() {
            return new DriverPos(this);
        }
    }
}
