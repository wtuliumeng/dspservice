package com.dsp.web.model.datamanage;

import java.util.Date;

public class FileRetrieval {
    //任务编号
    private String taskId;
    //文件名
    private String fileName;
    //数字签名
    private String digist;
    //生成时间
    private Date createTime;
    //状态
    private String status;
    //下载次数
    private Integer dtimes;

    public FileRetrieval() {
    }

    public FileRetrieval(String taskId, String fileName, String digist, Date createTime, String status, Integer dtimes) {
        this.taskId = taskId;
        this.fileName = fileName;
        this.digist = digist;
        this.createTime = createTime;
        this.status = status;
        this.dtimes = dtimes;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDigist() {
        return digist;
    }

    public void setDigist(String digist) {
        this.digist = digist;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDtimes() {
        return dtimes;
    }

    public void setDtimes(Integer dtimes) {
        this.dtimes = dtimes;
    }
}
