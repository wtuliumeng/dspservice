package com.dsp.web.service.datamanage.impl;

import com.dsp.web.model.datamanage.DataSets;
import com.dsp.web.model.datamanage.FileRetrieval;
import com.dsp.web.model.datamanage.FileRetrievalParam;
import com.dsp.web.service.datamanage.FileRetrievalService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FileRetrievalServiceImpl implements FileRetrievalService {
    private List<FileRetrieval> fileRetrievalList = new ArrayList<>();

    @Override
    public Long getDataSetsCount(FileRetrievalParam param) {
        if(this.fileRetrievalList.size() <= 0){
            for(int  i = 0;i < 5; i++){
                FileRetrieval retrieval = new FileRetrieval();
                retrieval.setTaskId("20200325123001123" + i);
                retrieval.setFileName("QS20200325123001" + i);
                retrieval.setCreateTime(new Date());
                retrieval.setDigist(i + "424200shds232k12");
                retrieval.setDtimes(i);
                this.fileRetrievalList.add(retrieval);
            }
        }
        return (long)this.fileRetrievalList.size();
    }

    @Override
    public List<FileRetrieval> getDataSetsList(FileRetrievalParam param) {
        /*造假数据*/
        List<FileRetrieval> fileRetrievalList1 = new ArrayList<>();
        for(int i = (param.getCurrentPage()-1)*param.getPageSize();i<this.fileRetrievalList.size();i++){
            fileRetrievalList1.add(this.fileRetrievalList.get(i));
            if(fileRetrievalList1.size()==param.getPageSize()){
                break;
            }
        }
        for(int i = 0;i < fileRetrievalList1.size();i++){
            if(fileRetrievalList1.get(i).getDtimes() > 0){
                fileRetrievalList1.get(i).setStatus("1");
            }else{
                fileRetrievalList1.get(i).setStatus("0");
            }
        }
        return fileRetrievalList1;
    }

    @Override
    public Map<String, String> getText(String taskId, String fileName) {
        Map<String,String> map = new HashMap<>(1);
        String text = "";
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 30;j++){
                text += 13213*j + i*121 + "|";
            }
            text += "\n";
        }
        map.put("text",text);
        return map;
    }
}
