package com.dsp.web.model.monitorCenter;

import com.dsp.web.model.vo.PageInfoExt;

/**
 * Created by zhouyang on 2020/3/24.
 */
public class OnSearchParam extends PageInfoExt {

    public String sqlId;
    public String name;
    public String resource;

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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
