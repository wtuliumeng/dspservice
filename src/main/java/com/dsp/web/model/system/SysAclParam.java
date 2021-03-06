package com.dsp.web.model.system;

import com.dsp.web.model.vo.PageInfoExt;

public class SysAclParam  extends PageInfoExt {
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
}
