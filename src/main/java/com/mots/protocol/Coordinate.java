package com.mots.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

import static com.squareup.wire.Message.Datatype.*;
import static com.squareup.wire.Message.Label.REQUIRED;

/**
 * 坐标
 */
public final class Coordinate extends Message {

    public static final Double DEFAULT_X = 0D;
    public static final Double DEFAULT_Y = 0D;
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Double DEFAULT_DX = 0D;
    public static final Double DEFAULT_DY = 0D;
    public static final Integer DEFAULT_ANGLE = 0;

    @ProtoField(tag = 1, type = DOUBLE, label = REQUIRED)
    public final Double x;

    @ProtoField(tag = 2, type = DOUBLE, label = REQUIRED)
    public final Double y;

    /**
     * 坐标系
     */
    @ProtoField(tag = 3, type = ENUM, label = REQUIRED)
    public final CoordinateType type;

    /**
     * 坐标产生时间,seconds since epoch(app可选上报，仅用于log分析)
     */
    @ProtoField(tag = 4, type = UINT32)
    public final Integer timestamp;

    @ProtoField(tag = 5, type = DOUBLE)
    public final Double dx;

    @ProtoField(tag = 6, type = DOUBLE)
    public final Double dy;

    /**
     * 新增字段
     */
    @ProtoField(tag = 7, type = INT32)
    public final Integer angle;

    public Coordinate(Double x, Double y, CoordinateType type, Integer timestamp, Double dx, Double dy, Integer angle) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.timestamp = timestamp;
        this.dx = dx;
        this.dy = dy;
        this.angle = angle;
    }

    private Coordinate(Builder builder) {
        this(builder.x, builder.y, builder.type, builder.timestamp, builder.dx, builder.dy, builder.angle);
        setBuilder(builder);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Coordinate)) return false;
        Coordinate o = (Coordinate) other;
        return equals(x, o.x)
                && equals(y, o.y)
                && equals(type, o.type)
                && equals(timestamp, o.timestamp)
                && equals(dx, o.dx)
                && equals(dy, o.dy)
                && equals(angle, o.angle);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = x != null ? x.hashCode() : 0;
            result = result * 37 + (y != null ? y.hashCode() : 0);
            result = result * 37 + (type != null ? type.hashCode() : 0);
            result = result * 37 + (timestamp != null ? timestamp.hashCode() : 0);
            result = result * 37 + (dx != null ? dx.hashCode() : 0);
            result = result * 37 + (dy != null ? dy.hashCode() : 0);
            result = result * 37 + (angle != null ? angle.hashCode() : 0);
            hashCode = result;
        }
        return result;
    }

    public static final class Builder extends Message.Builder<Coordinate> {

        public Double x;
        public Double y;
        public CoordinateType type;
        public Integer timestamp;
        public Double dx;
        public Double dy;
        public Integer angle;

        public Builder() {
        }

        public Builder(Coordinate message) {
            super(message);
            if (message == null) return;
            this.x = message.x;
            this.y = message.y;
            this.type = message.type;
            this.timestamp = message.timestamp;
            this.dx = message.dx;
            this.dy = message.dy;
            this.angle = message.angle;
        }

        public Builder x(Double x) {
            this.x = x;
            return this;
        }

        public Builder y(Double y) {
            this.y = y;
            return this;
        }

        /**
         * 坐标系
         */
        public Builder type(CoordinateType type) {
            this.type = type;
            return this;
        }

        /**
         * 坐标产生时间,seconds since epoch(app可选上报，仅用于log分析)
         */
        public Builder timestamp(Integer timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder dx(Double dx) {
            this.dx = dx;
            return this;
        }

        public Builder dy(Double dy) {
            this.dy = dy;
            return this;
        }

        /**
         * 新增字段
         */
        public Builder angle(Integer angle) {
            this.angle = angle;
            return this;
        }

        @Override
        public Coordinate build() {
            checkRequiredFields();
            return new Coordinate(this);
        }
    }
}
