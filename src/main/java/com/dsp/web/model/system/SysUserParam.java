package com.dsp.web.model.system;

import com.dsp.web.model.vo.PageInfoExt;

import java.io.Serializable;
/**
 *@Description:sys_user
 *@author root
 *@version 1.0,
 *@date 2018-07-06 15:17:35
 */
public class SysUserParam extends PageInfoExt implements Serializable {

	private static final long serialVersionUID = 1L;

	/**主键*/
	private Long id;

	/**USER_NAME*/
	private String userName;

	/**USER_NO*/
	private String userNo;

	/**LOGIN_NAME*/
	private String loginName;


	/**MOBILE*/
	private String mobile;


	/**SEX*/
	private String sex;


	/**JOB*/
	private String job;

	private Long orgid;
	private Long positionid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public Long getPositionid() {
		return positionid;
	}

	public void setPositionid(Long positionid) {
		this.positionid = positionid;
	}
}