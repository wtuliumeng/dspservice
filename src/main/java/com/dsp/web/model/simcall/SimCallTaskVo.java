package com.dsp.web.model.simcall;




public class SimCallTaskVo {
    /**
     * 用户名
     * token令牌
     * 认证时间
     */
    private String sqlId;           //任务编号
    private String state;           //任务状态
    private String retCode;         //返回码
    private String description;     //描述

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
