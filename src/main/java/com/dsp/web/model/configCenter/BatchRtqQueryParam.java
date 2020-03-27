package com.dsp.web.model.configCenter;

import com.dsp.web.model.vo.PageInfoExt;

public class BatchRtqQueryParam extends PageInfoExt {
    private static final long serialVersionUID = 1L;

    /* 用户名 */
    public String sqlId;
    /* 允许IP */
    public String dbSource;
    /* 状态 */
    public String status;

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
