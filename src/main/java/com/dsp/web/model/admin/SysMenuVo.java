package com.dsp.web.model.admin;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/18.
 */
public class SysMenuVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**主键*/
    private Long id;

    /**MENU_CODE*/
    private String menuCode;

    /**MENU_NAME*/
    private String menuName;

    /**MENU_ICON*/
    private String menuIcon;

    /**MENU_URL*/
    private String menuUrl;

    /**PARENT_ID*/
    private String parentId;

    /**ORDER_BY*/
    private String orderBy;

    /**VALIDATE_STATE*/
    private String validateState;

    /**APP_ID*/
    private Long appId;

    /**VERSION*/
    private Long version;

    /**RESOURCE_ID*/
    private Long resourceId;
    /**菜单是否显示*/
    private int isShow;
    public static List<TreeNodeVo> ToTreeModel(List<SysMenuVo> list)
    {
        List<TreeNodeVo> treelist=new ArrayList<>();
        for (SysMenuVo vo:list) {
            TreeNodeVo treenode=new TreeNodeVo();
            treenode.setId(vo.getId().toString());
            treenode.setName(vo.getMenuName());
            treenode.setParentId(vo.getParentId());
            treelist.add(treenode);
        }
        return TreeNodeVo.treeBuild(treelist);

    }

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

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getValidateState() {
        return validateState;
    }

    public void setValidateState(String validateState) {
        this.validateState = validateState;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }
}
