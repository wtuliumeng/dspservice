package com.dsp.web.model.shiro;



import org.springframework.web.bind.annotation.Mapping;

import java.io.Serializable;


public class UserInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    //@Mapping("id")
    private Long userId;
    private String userName;
    private String userNo;
    private String loginName;
    private Long orgId;
    private String orgName;
    private String salt;
    private String password;
    private String email;
    private String loginTime;
    private String orgParentId;
    private String orgParentName;
    private String positionName;
    /*sessionid*/
    private String token;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getOrgParentId() {
        return orgParentId;
    }

    public void setOrgParentId(String orgParentId) {
        this.orgParentId = orgParentId;
    }

    public String getOrgParentName() {
        return orgParentName;
    }

    public void setOrgParentName(String orgParentName) {
        this.orgParentName = orgParentName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userNo='" + userNo + '\'' +
                ", loginName='" + loginName + '\'' +
                ", orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", orgParentId='" + orgParentId + '\'' +
                ", orgParentName='" + orgParentName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
