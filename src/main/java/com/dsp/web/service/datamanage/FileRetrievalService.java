package com.dsp.web.service.datamanage;

import com.dsp.web.model.datamanage.FileRetrieval;
import com.dsp.web.model.datamanage.FileRetrievalParam;

import java.util.List;
import java.util.Map;

public interface FileRetrievalService {
    Long getDataSetsCount(FileRetrievalParam param);

    List<FileRetrieval> getDataSetsList(FileRetrievalParam param);

    Map<String,String> getText(String taskId, String fileName);
}
