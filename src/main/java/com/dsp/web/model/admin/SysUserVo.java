package com.dsp.web.model.admin;



import java.io.Serializable;
import java.util.Date;

;

/**
 * @author root
 * @version 1.0,
 * @Description:sys_user
 * @date 2018-07-06 15:17:35
 */
public class SysUserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * USER_NAME
     */
    private String userName;

    /**
     * USER_NO
     */
    private String userNo;

    /**
     * LOGIN_NAME
     */
    private String loginName;

    /**
     * PASSWORD
     */
    private String password;

    /**
     * SALT
     */
    private String salt;

    /**
     * MOBILE
     */
    private String mobile;

    /**
     * EMAIL
     */
    private String email;

    /**
     * USER_IMAGE
     */
    private String userImage;

    /**
     * SEX
     */
    private String sex;

    /**
     * BIRTHDAY
     */
    private String birthday;

    /**
     * NATIONALITY
     */
    private String nationality;

    /**
     * EDUCATION
     */
    private String education;

    /**
     * JOB
     */
    private String job;

    /**
     * HOME_ADDRESS
     */
    private String homeAddress;

    /**
     * HOME_ZIPCODE
     */
    private String homeZipcode;

    /**
     * HOME_TEL
     */
    private String homeTel;

    /**
     * OFFICE_TEL
     */
    private String officeTel;

    /**
     * OFFICE_ADDRESS
     */
    private String officeAddress;

    /**
     * ORDER_BY
     */
    private String orderBy;

    /**
     * VALIDATE_STATE
     */
    private String validateState;

    /**
     * IS_LOCKED
     */
    private String isLocked;

    /**
     * VERSION
     */
    private Long version;

    /**
     * 创建时间
     */
    private java.util.Date createDate;

    /**
     * CARD_NO
     */
    private String cardNo;

    /**
     * PROBATION_PERIOD
     */
    private Long probationPeriod;

    /**
     * 入职日期
     */
    private java.util.Date entryDate;

    /**
     * 离职日期
     */
    private java.util.Date quitDate;

    /**
     * 参加工作日期
     */
    private java.util.Date workDate;

    /**
     * POLITICAL_STATUS
     */
    private String politicalStatus;

    /**
     * USER_RELATION
     */
    private String userRelation;

    /**
     * ANNUAL_LEAVE
     */
    private Long annualLeave;

    /**
     * JXZJ
     */
    private String jxzj;

    /**
     * NJQSRQ
     */
    private java.util.Date njqsrq;

    /**
     * UUID
     */
    private String uuid;
    private Long orgid;
    private Long positionid;

    private String orgname;
    private String positionname;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeZipcode() {
        return homeZipcode;
    }

    public void setHomeZipcode(String homeZipcode) {
        this.homeZipcode = homeZipcode;
    }

    public String getHomeTel() {
        return homeTel;
    }

    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
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

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Long getProbationPeriod() {
        return probationPeriod;
    }

    public void setProbationPeriod(Long probationPeriod) {
        this.probationPeriod = probationPeriod;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getUserRelation() {
        return userRelation;
    }

    public void setUserRelation(String userRelation) {
        this.userRelation = userRelation;
    }

    public Long getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(Long annualLeave) {
        this.annualLeave = annualLeave;
    }

    public String getJxzj() {
        return jxzj;
    }

    public void setJxzj(String jxzj) {
        this.jxzj = jxzj;
    }

    public Date getNjqsrq() {
        return njqsrq;
    }

    public void setNjqsrq(Date njqsrq) {
        this.njqsrq = njqsrq;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }
}
