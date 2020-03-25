package com.dsp.web.model.simcall;


/**
 * 异步任务模拟调用前端参数
 */
public class SimCallTask {
    private String sqlId;               //任务编号
    private String userName;            //用户名
    private String ip;                  //ip
    private String token;               //token令牌
    private String params;              //提数参数

    private String totalDataParam;      //数据总量参数
    private String batchParam;          //跑批参数

    private String pageNum;             //页码
    private String countPage;           //每页记录数

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getTotalDataParam() {
        return totalDataParam;
    }

    public void setTotalDataParam(String totalDataParam) {
        this.totalDataParam = totalDataParam;
    }

    public String getBatchParam() {
        return batchParam;
    }

    public void setBatchParam(String batchParam) {
        this.batchParam = batchParam;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getCountPage() {
        return countPage;
    }

    public void setCountPage(String countPage) {
        this.countPage = countPage;
    }
}
