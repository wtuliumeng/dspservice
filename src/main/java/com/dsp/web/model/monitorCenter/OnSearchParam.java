package com.dsp.web.model.monitorCenter;

import com.dsp.web.model.vo.PageInfoExt;

/**
 * Created by zhouyang on 2020/3/24.
 */
public class OnSearchParam extends PageInfoExt {
    private static final long serialVersionUID = 1L;

    public String sqlId;
    public String name;
    public String status;

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
