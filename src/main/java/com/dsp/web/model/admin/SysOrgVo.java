package com.dsp.web.model.admin;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *@Description:sys_org
 *@author root
 *@version 1.0,
 *@date 2018-07-06 09:52:41
 */
public class SysOrgVo implements Serializable{

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

	/**PARENT_IDS*/
	private String parentIds;

	/**ORDER_BY*/
	private String orderBy;

	/**VALIDATE_STATE*/
	private String validateState;

	/**IS_VIRTUAL*/
	private String isVirtual;

	/**VERSION*/
	private Long version;

	/**APP_FLAG*/
	private String appFlag;

	/**IS_LEEF*/
	private String isLeef;

	/**AREA_CODES*/
	private String areaCodes;

	/**AREA_ADRESS*/
	private String areaAdress;

	/**ORG_LEVEL*/
	private String orgLevel;

	/**EFFECTIVE_DATE*/
	private java.util.Date effectiveDate;

	/**CREATE_TIME*/
	private java.util.Date createTime;

	/**UUID*/
	private String uuid;

	/**remark*/
	private String remark;

	public static List<TreeNodeVo> ToTreeModel(List<SysOrgVo> list)
	{
		List<TreeNodeVo> treelist=new ArrayList<>();
		for (SysOrgVo vo:list) {
			TreeNodeVo treenode=new TreeNodeVo();
			treenode.setId(vo.getId().toString());
			treenode.setName(vo.getOrgName());
			treenode.setParentId(vo.getParentId());
			treenode.setLevel(vo.getOrgLevel());
			treenode.setOrgType(vo.getOrgType());
			treenode.setValidateState(vo.getValidateState());
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

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
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

	public String getIsVirtual() {
		return isVirtual;
	}

	public void setIsVirtual(String isVirtual) {
		this.isVirtual = isVirtual;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getAppFlag() {
		return appFlag;
	}

	public void setAppFlag(String appFlag) {
		this.appFlag = appFlag;
	}

	public String getIsLeef() {
		return isLeef;
	}

	public void setIsLeef(String isLeef) {
		this.isLeef = isLeef;
	}

	public String getAreaCodes() {
		return areaCodes;
	}

	public void setAreaCodes(String areaCodes) {
		this.areaCodes = areaCodes;
	}

	public String getAreaAdress() {
		return areaAdress;
	}

	public void setAreaAdress(String areaAdress) {
		this.areaAdress = areaAdress;
	}

	public String getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}