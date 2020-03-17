package com.dsp.web.model.shiro;




public class UserInfoParam {
    private static final long serialVersionUID = 1L;
    private String loginName;
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
}
