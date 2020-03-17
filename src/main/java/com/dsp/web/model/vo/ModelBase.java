package com.dsp.web.model.vo;


import java.util.UUID;

/**
 * DTO和VO的基类提供幂等的uuid
 */

public class ModelBase {
    public String uuid= UUID.randomUUID().toString();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
