package com.mots.protocol;

import com.squareup.wire.ProtoEnum;

public enum CoordinateType
        implements ProtoEnum {
    /**
     * 百度坐标系,BD-09
     */
    BD_09(1),
    /**
     * SOSO坐标系,GCJ-02
     */
    GCJ_02(2),
    /**
     * 国际标准坐标系,WGS-84
     */
    WGS_84(4);

    private final int value;

    private CoordinateType(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
