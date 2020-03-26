package com.dsp.web.model.monitorCenter;

import java.util.Date;

/**
 * Created by zhouyang on 2020/3/26.
 */
public class QuerySearch {
    //﻿查询编号
    private String querynumber;
    //﻿任务编号
    private String tasknumber;
    //﻿调用方系统
    private String callsystem;
    //﻿调用日期
    private String calldate;
    //﻿调用参数
    private String callparam;
    //﻿服务名
    private String servicename;
    //﻿请求时间
    private Date requestdate;
    //返回时间
    private Date returndate;
    //﻿响应代码
    private String responcode;
    //﻿任务状态
    private String state;
    //﻿描述
    private String descr;

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

    public String getCalldate() {
        return calldate;
    }

    public void setCalldate(String calldate) {
        this.calldate = calldate;
    }

    public String getCallparam() {
        return callparam;
    }

    public void setCallparam(String callparam) {
        this.callparam = callparam;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public Date getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(Date requestdate) {
        this.requestdate = requestdate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public String getResponcode() {
        return responcode;
    }

    public void setResponcode(String responcode) {
        this.responcode = responcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
