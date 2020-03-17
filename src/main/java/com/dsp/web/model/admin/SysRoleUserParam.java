package com.dsp.web.model.admin;


import com.dsp.web.model.vo.PageInfoExt;

public class SysRoleUserParam extends PageInfoExt {

    private static final long serialVersionUID = 1L;

    /**主键*/
    private Long id;

    /**ROLE_ID*/
    private Long roleId;

    /**TARGET_ID*/
    private Long targetId;

    /**APP_ID*/
    private Long appId;

    /**TARGET_TYPE*/
    private String targetType;

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

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
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
