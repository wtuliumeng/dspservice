package com.dsp.web.model.configCenter;

import java.util.ArrayList;
import java.util.List;

public class BatchRtq {
    /* sql编号 */
    private String sqlId;
    /* 调用方系统 */
    private String userName;
    /* 取数sql */
    private String sqlContext;
    /* 参数个数 */
    private String paramCount;
    /* 取数参数 */
    private String params;
    /* 跑批sql */
    private String csqlContext;
    /* 跑批参数 */
    private String listParamLimit;
    /* 状态 */
    private String status;
    /* 表名 */
    private String tableName;
    /* 数据源 */
    private String dbSource;

    private List<String> sqlIds = new ArrayList<>();

    public List<String> getSqlIds() {
        return sqlIds;
    }

    public void setSqlIds(List<String> sqlIds) {
        this.sqlIds = sqlIds;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSqlContext() {
        return sqlContext;
    }

    public void setSqlContext(String sqlContext) {
        this.sqlContext = sqlContext;
    }

    public String getParamCount() {
        return paramCount;
    }

    public void setParamCount(String paramCount) {
        this.paramCount = paramCount;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getCsqlContext() {
        return csqlContext;
    }

    public void setCsqlContext(String csqlContext) {
        this.csqlContext = csqlContext;
    }

    public String getListParamLimit() {
        return listParamLimit;
    }

    public void setListParamLimit(String listParamLimit) {
        this.listParamLimit = listParamLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
