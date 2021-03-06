package com.dsp.web.model.system;

import java.io.Serializable;
/**
 *@Description:sys_position
 *@author root
 *@version 1.0,
 *@date 2018-07-06 15:17:29
 */
public class SysPositionVo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键*/
	private Long id;

	/**POSITION_NAME*/
	private String positionName;

	/**POSITION_CODE*/
	private String positionCode;

	/**ORDER_BY*/
	private String orderBy;

	/**VALIDATE_STATE*/
	private String validateState;

	/**VERSION*/
	private Long version;

	/**创建时间*/
//	@ApiModelProperty(value="创建时间")
//	private java.util.Date createDate;

	/**ORG_CODE*/
	private String orgCode;

	/**IS_RESPONSIBLE*/
	private String isResponsible;

	/**POSITION_SEQUENCE*/
	private String positionSequence;

	/**POST*/
	private String post;

	/**有效日期*/
//	@ApiModelProperty(value="有效日期")
//	private java.util.Date effectiveDate;

	/**PARENT_ID*/
	private String parentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getIsResponsible() {
		return isResponsible;
	}

	public void setIsResponsible(String isResponsible) {
		this.isResponsible = isResponsible;
	}

	public String getPositionSequence() {
		return positionSequence;
	}

	public void setPositionSequence(String positionSequence) {
		this.positionSequence = positionSequence;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}