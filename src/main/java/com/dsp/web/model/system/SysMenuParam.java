package com.dsp.web.model.system;

import java.io.Serializable;


public class SysMenuParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**主键*/
    private Long id;

    /**MENU_CODE*/
    private String menuCode;

    /**MENU_NAME*/
    private String menuName;

    /**PARENT_ID*/
    private String parentId;

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

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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