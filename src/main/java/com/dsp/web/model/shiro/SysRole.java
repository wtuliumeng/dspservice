package com.dsp.web.model.shiro;


import java.io.Serializable;

/**
 *@Description:sys_role
 *@author root
 *@version 1.0,
 *@date 2018-06-22 02:10:07
 */

public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ROLE_NAME
     */
    private String roleName;

    /**
     * ROLE_CODE
     */
    private String roleCode;

    /**
     * ROLE_TYPE
     */
    private String roleType;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
