package com.dsp.web.model.admin;


import com.dsp.web.model.vo.PageInfoExt;

/**
 *@Description:sys_role
 *@author root
 *@version 1.0,
 *@date 2018-07-06 15:26:11
 */

public class SysRoleParam extends PageInfoExt {

	private static final long serialVersionUID = 1L;

	/**主键*/
	private Long id;

	/**ROLE_NAME*/
	private String roleName;

	/**ROLE_CODE*/
	private String roleCode;

	/**ROLE_TYPE*/
	private String roleType;

	/**APP_ID*/
	private Long appId;

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

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
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