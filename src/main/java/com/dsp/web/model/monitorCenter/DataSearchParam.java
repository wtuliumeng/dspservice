package com.dsp.web.model.monitorCenter;

import com.dsp.web.model.vo.PageInfoExt;

import java.util.Date;

/**
 * Created by zhouyang on 2020/3/26.
 */
public class DataSearchParam extends PageInfoExt {
    private String name;
    private String sqlname;
    private String switcsystem;
    private String resource;
    private Date rundate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSqlname() {
        return sqlname;
    }

    public void setSqlname(String sqlname) {
        this.sqlname = sqlname;
    }

    public String getSwitcsystem() {
        return switcsystem;
    }

    public void setSwitcsystem(String switcsystem) {
        this.switcsystem = switcsystem;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Date getRundate() {
        return rundate;
    }

    public void setRundate(Date rundate) {
        this.rundate = rundate;
    }
}
