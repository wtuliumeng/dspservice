package com.dsp.web.model.datamanage;

import com.dsp.web.model.vo.PageInfoExt;

public class DataRetrievalParam extends PageInfoExt {
    //sql编号
    private String sqlId;
    //运行日期
    private String date;
    //用户id
    private String userId;

    public DataRetrievalParam() {
    }

    public DataRetrievalParam(String sqlId, String date, String userId) {
        this.sqlId = sqlId;
        this.date = date;
        this.userId = userId;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
