package com.dsp.web.model.admin;


import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/18.
 */
public class SysAclVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**主键*/
    private Long id;

    /**ROLE_ID*/
    private Long roleId;

    /**RESOURE_ID*/
    private Long resoureId;

    /**ACCESSIBILITY*/
    private Long accessibility;

    /**APP_ID*/
    private Long appId;

    /**VALIDATE_STATE*/
    private String validateState;

    /**VERSION*/
    private Long version;

    private String[] resourceids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResoureId() {
        return resoureId;
    }

    public void setResoureId(Long resoureId) {
        this.resoureId = resoureId;
    }

    public Long getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Long accessibility) {
        this.accessibility = accessibility;
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

    public String[] getResourceids() {
        return resourceids;
    }

    public void setResourceids(String[] resourceids) {
        this.resourceids = resourceids;
    }
}
