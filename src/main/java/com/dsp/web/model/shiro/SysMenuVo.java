package com.dsp.web.model.shiro;



import java.io.Serializable;
import java.util.List;

/**
 *@Description:sys_menu
 *@author root
 *@version 1.0,
 *@date 2018-07-11 11:51:28
 */

public class SysMenuVo implements Serializable{

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
	/**是否显示菜单*/
	private int isShow;

//	/**VALIDATE_STATE*/
//	@ApiModelProperty(value="VALIDATE_STATE")
//	private String validateState;

//	/**APP_ID*/
//	@ApiModelProperty(value="APP_ID")
//	private Long appId;

//	/**VERSION*/
//	@ApiModelProperty(value="VERSION")
//	private Long version;

//	/**RESOURCE_ID*/
//	@ApiModelProperty(value="resourceId")
//	private Long resourceId;
	/*扩展字段*/
	/* 资源url */
	private String resoure_url;
	/* 资源类型 */
	private String resoure_type;
	/* 资源标示 */
	private String permission;
	/*子菜单*/
	List<SysMenuVo> sysMenuVoChild;

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

	public int getIsShow() {
		return isShow;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}

	public String getResoure_url() {
		return resoure_url;
	}

	public void setResoure_url(String resoure_url) {
		this.resoure_url = resoure_url;
	}

	public String getResoure_type() {
		return resoure_type;
	}

	public void setResoure_type(String resoure_type) {
		this.resoure_type = resoure_type;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<SysMenuVo> getSysMenuVoChild() {
		return sysMenuVoChild;
	}

	public void setSysMenuVoChild(List<SysMenuVo> sysMenuVoChild) {
		this.sysMenuVoChild = sysMenuVoChild;
	}
}