package com.dsp.web.model.datamanage;

import com.dsp.web.model.vo.PageInfoExt;

public class FileRetrievalParam extends PageInfoExt {
    private String taskId;
    private String fileName;
    private String userId;

    public FileRetrievalParam() {
    }

    public FileRetrievalParam(String taskId, String fileName, String userId) {
        this.taskId = taskId;
        this.fileName = fileName;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
