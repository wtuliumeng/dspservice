package com.dsp.web.model.mon;

import com.dsp.web.model.vo.PageInfoExt;

import java.util.Date;

/**
 * Created by zhouyang on 2020/3/26.
 */
public class RealCallParam extends PageInfoExt {
    //﻿查询编号
    private String querynumber;
    //﻿任务编号
    private String tasknumber;
    //﻿调用方系统
    private String callsystem;
    //任务状态
    private String status;
    //﻿运行日期
    private Date rundate;

    public String getQuerynumber() {
        return querynumber;
    }

    public void setQuerynumber(String querynumber) {
        this.querynumber = querynumber;
    }

    public String getTasknumber() {
        return tasknumber;
    }

    public void setTasknumber(String tasknumber) {
        this.tasknumber = tasknumber;
    }

    public String getCallsystem() {
        return callsystem;
    }

    public void setCallsystem(String callsystem) {
        this.callsystem = callsystem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String resource) {
        this.status = resource;
    }

    public Date getRundate() {
        return rundate;
    }

    public void setRundate(Date rundate) {
        this.rundate = rundate;
    }
}
