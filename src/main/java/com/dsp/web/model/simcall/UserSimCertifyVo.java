package com.dsp.web.model.simcall;




public class UserSimCertifyVo {
    /**
     * 用户名
     * token令牌
     * 认证时间
     */
    private String userName;
    private String token;
    private String authTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuthTime() {
        return authTime;
    }

    public void setAuthTime(String authTime) {
        this.authTime = authTime;
    }
}
