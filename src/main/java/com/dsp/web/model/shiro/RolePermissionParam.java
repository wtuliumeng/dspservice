package com.dsp.web.model.shiro;



public class RolePermissionParam {
    /**RESOURE_TYPE*/
    public String resoureType;
    /* userid*/
    public Long userId;

    public String getResoureType() {
        return resoureType;
    }

    public void setResoureType(String resoureType) {
        this.resoureType = resoureType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
