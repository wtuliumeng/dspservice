package com.dsp.web.model.admin;


import java.io.Serializable;

/**
 *@Description:sys_role_user
 *@author root
 *@version 1.0,
 *@date 2018-07-06 15:17:47
 */

public class SysRoleUserVo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键*/
	private Long id;

	/**ROLE_ID*/
	private Long roleId;

	/**TARGET_ID*/
	private Long targetId;

	/**UserName*/
	private String userName;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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