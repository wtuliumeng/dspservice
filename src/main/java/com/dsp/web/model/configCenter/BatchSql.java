package com.dsp.web.model.configCenter;

public class BatchSql {
    /* 任务编号 */
    private String sqlID;
    /* 取数sql */
    private String sqlContext;
    /* 取数参数 */
    private String params;
    /* 数据项个数 */
    private String plength;
    /* 所属任务 */
    private String userName;
    /* 状态 */
    private String status;
    /* 总量sql */
    private String tsqlContext;
    /* 文件保存路径 */
    private String dirName;
    /* 跑批sql */
    private String csqlContext;
    /* 表名 */
    private String tableName;
    /* 数据源 */
    private String DBSource;

    public String getSqlID() {
        return sqlID;
    }

    public void setSqlID(String sqlID) {
        this.sqlID = sqlID;
    }

    public String getSqlContext() {
        return sqlContext;
    }

    public void setSqlContext(String sqlContext) {
        this.sqlContext = sqlContext;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getPlength() {
        return plength;
    }

    public void setPlength(String plength) {
        this.plength = plength;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTsqlContext() {
        return tsqlContext;
    }

    public void setTsqlContext(String tsqlContext) {
        this.tsqlContext = tsqlContext;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getCsqlContext() {
        return csqlContext;
    }

    public void setCsqlContext(String csqlContext) {
        this.csqlContext = csqlContext;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDBSource() {
        return DBSource;
    }

    public void setDBSource(String DBSource) {
        this.DBSource = DBSource;
    }
}
