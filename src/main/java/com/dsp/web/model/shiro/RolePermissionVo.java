package com.dsp.web.model.shiro;


public class RolePermissionVo {
    /*资源名称*/
    private String resoureName;
    /*权限标示,根据权限标示区分按钮,有权限标示的显示*/
    private String permission;

    public String getResoureName() {
        return resoureName;
    }

    public void setResoureName(String resoureName) {
        this.resoureName = resoureName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
