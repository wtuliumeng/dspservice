package com.dsp.web.model.datamanage;

import com.dsp.web.model.vo.PageInfoExt;

public class DataSetsParam extends PageInfoExt {
    //数据集名称
    private String dataSetsName;
    //数据集标识
    private String dataSetsId;
    //数据集类型
    private String dataSetsType;
    //用户编号
    private String userId;

    public String getDataSetsName() {
        return dataSetsName;
    }

    public void setDataSetsName(String dataSetsName) {
        this.dataSetsName = dataSetsName;
    }

    public String getDataSetsId() {
        return dataSetsId;
    }

    public void setDataSetsId(String dataSetsId) {
        this.dataSetsId = dataSetsId;
    }

    public String getDataSetsType() {
        return dataSetsType;
    }

    public void setDataSetsType(String dataSetsType) {
        this.dataSetsType = dataSetsType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DataManageParam{" +
                "dataSetsName='" + dataSetsName + '\'' +
                ", dataSetsId='" + dataSetsId + '\'' +
                ", dataSetsType='" + dataSetsType + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
