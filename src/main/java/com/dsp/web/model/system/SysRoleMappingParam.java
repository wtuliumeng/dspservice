package com.dsp.web.model.system;

import com.dsp.web.model.vo.PageInfoExt;

public class SysRoleMappingParam extends PageInfoExt {
    private static final long serialVersionUID = 1L;

    /**主键ID*/
    private Long id;

    /**ROLE_CODE*/
    private String roleCode;

    /**MAPPING_ROLE_CODE*/
    private String mappingRoleCode;

    /**VALIDATE_STATE*/
    private String validateState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getMappingRoleCode() {
        return mappingRoleCode;
    }

    public void setMappingRoleCode(String mappingRoleCode) {
        this.mappingRoleCode = mappingRoleCode;
    }

    public String getValidateState() {
        return validateState;
    }

    public void setValidateState(String validateState) {
        this.validateState = validateState;
    }
}
