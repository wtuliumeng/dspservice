package com.dsp.web.model.admin;


import java.io.Serializable;

public class SysOrgParam  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**ID*/
    private Long id;

    /**ORG_CODE*/
    private String orgCode;

    /**ORG_NAME*/
    private String orgName;

    /**ORG_TYPE*/
    private String orgType;

    /**PARENT_ID*/
    private String parentId;

    /**ORG_LEVEL*/
    private String orgLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel;
    }
}
