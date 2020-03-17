package com.dsp.web.model.shiro;



public class RolePermission {
    /**资源URL*/
    private String resoureUrl;
    /**资源类型*/
    private String resoureType;
    /*角色编码*/
    private String role_code;
    /*权限标示*/
    private String permission;
    /*资源名称*/
    private String resoureName;

    public String getResoureUrl() {
        return resoureUrl;
    }

    public void setResoureUrl(String resoureUrl) {
        this.resoureUrl = resoureUrl;
    }

    public String getResoureType() {
        return resoureType;
    }

    public void setResoureType(String resoureType) {
        this.resoureType = resoureType;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getResoureName() {
        return resoureName;
    }

    public void setResoureName(String resoureName) {
        this.resoureName = resoureName;
    }
}
