package com.dsp.web.model.admin;


import java.io.Serializable;


public class SysResourceParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**主键*/
    private Long id;

    /**RESOURE_NAME*/
    private String resoureName;

    /**RESOURE_TYPE*/
    private String resoureType;

    /**RESOURE_URL*/
    private String resoureUrl;

    /**PERMISSION*/
    private String permission;

    /**PARENT_ID*/
    private String parentId;

    /**PARENT_IDS*/
    private String parentIds;

    /**APP_ID*/
    private Long appId;

    /**VALIDATE_STATE*/
    private String validateState;

    /**VERSION*/
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResoureName() {
        return resoureName;
    }

    public void setResoureName(String resoureName) {
        this.resoureName = resoureName;
    }

    public String getResoureType() {
        return resoureType;
    }

    public void setResoureType(String resoureType) {
        this.resoureType = resoureType;
    }

    public String getResoureUrl() {
        return resoureUrl;
    }

    public void setResoureUrl(String resoureUrl) {
        this.resoureUrl = resoureUrl;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getValidateState() {
        return validateState;
    }

    public void setValidateState(String validateState) {
        this.validateState = validateState;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
