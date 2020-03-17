package com.dsp.web.model.shiro;


import java.util.List;

public class LoginInfoVo {
    /* 用户信息 */
    public UserInfo userInfo;
    /* 角色信息 */
    public List<SysRoleVo> sysRoleVoList;
    /* 权限信息 */
    public List<RolePermissionVo> rolePermissionVoList;
    /* 菜单信息 */
    public List<SysMenuVo> sysMenuVoList;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<SysRoleVo> getSysRoleVoList() {
        return sysRoleVoList;
    }

    public void setSysRoleVoList(List<SysRoleVo> sysRoleVoList) {
        this.sysRoleVoList = sysRoleVoList;
    }

    public List<RolePermissionVo> getRolePermissionVoList() {
        return rolePermissionVoList;
    }

    public void setRolePermissionVoList(List<RolePermissionVo> rolePermissionVoList) {
        this.rolePermissionVoList = rolePermissionVoList;
    }

    public List<SysMenuVo> getSysMenuVoList() {
        return sysMenuVoList;
    }

    public void setSysMenuVoList(List<SysMenuVo> sysMenuVoList) {
        this.sysMenuVoList = sysMenuVoList;
    }
}
