package com.dsp.web.model.configCenter;

import com.dsp.web.model.vo.PageInfoExt;

public class BatchAuthQueryParam  extends PageInfoExt {
    private static final long serialVersionUID = 1L;

    /* 用户名 */
    public String userName;
    /* 允许IP */
    public String IPAddr;
    /* 状态 */
    public String status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIPAddr() {
        return IPAddr;
    }

    public void setIPAddr(String IPAddr) {
        this.IPAddr = IPAddr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
