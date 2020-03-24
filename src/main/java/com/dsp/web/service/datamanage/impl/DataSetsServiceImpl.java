package com.dsp.web.service.datamanage.impl;

import com.dsp.web.model.datamanage.DataSetsParam;
import com.dsp.web.model.datamanage.DataSets;
import com.dsp.web.service.common.SelectService;
import com.dsp.web.service.datamanage.DataSetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DataSetsServiceImpl implements DataSetsService{

    @Autowired
    private SelectService selectService;

    /*造假数据*/
    private List<DataSets> dataSetsVoList = new ArrayList<>();

    /**
     * 查询数据集列表
     * @param dataSetsParam
     * @return
     */
    @Override
    public List<DataSets> getDataSetsList(DataSetsParam dataSetsParam) {
        /*造假数据*/
        List<DataSets> dataSetsVoList1 = new ArrayList<>();
        for(int i = (dataSetsParam.getCurrentPage()-1)*dataSetsParam.getPageSize();i<this.dataSetsVoList.size();i++){
            dataSetsVoList1.add(this.dataSetsVoList.get(i));
            if(dataSetsVoList1.size()==dataSetsParam.getPageSize()){
                break;
            }
        }
        for(int i = 0;i < dataSetsVoList1.size();i++){
            dataSetsVoList1.get(i).setTypeName(selectService.getLabel("1",dataSetsVoList1.get(i).getType()).getLabel());
        }
        return dataSetsVoList1;
    }

    /**
     * 查询数据总量
     * @param dataSetsParam
     * @return
     */
    @Override
    public Long getDataSetsCount(DataSetsParam dataSetsParam) {
        /*造假数据*/
        if(this.dataSetsVoList.size() <= 0){
            //如果没有数据，则插入10条假数据
            for(int i = 0 ; i < 5 ;i++){
                DataSets dataSetsVo1 = new DataSets();
                dataSetsVo1.setAttribute("用于渠道开发信用卡年费提醒");
                dataSetsVo1.setCreateTime(new Date());
                dataSetsVo1.setDesc("id-编号 name-名称 load_time-贷款日期");
                dataSetsVo1.setName("信用卡年费提醒");
                dataSetsVo1.setType("1");
                dataSetsVo1.setUpdateTime(new Date());
                dataSetsVo1.setVersion("V1.0");
                dataSetsVo1.setId("load_info" + i);
                dataSetsVo1.setCreateUser("刘猛");
                dataSetsVo1.setTypeName("贷款类");
                this.dataSetsVoList.add(dataSetsVo1);
            }
        }
        return (long)this.dataSetsVoList.size();
    }

    @Override
    public boolean add(DataSets dataSetsVo) {
        if(dataSetsVo!=null){
            this.dataSetsVoList.add(0,dataSetsVo);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if(!StringUtils.isEmpty(id)){
            for(int i = 0;i<this.dataSetsVoList.size();i++){
                if(this.dataSetsVoList.get(i).getId().equals(id)){
                    this.dataSetsVoList.remove(i);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBatch(List<String> ids) {
        boolean flag = true;
        for(int i = 0; i < ids.size() ;i++){
            boolean rt = this.delete(ids.get(i));
            if(!rt){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public boolean update(DataSets dataSetsVo) {
        if(!StringUtils.isEmpty(dataSetsVo.getId())){
            this.delete(dataSetsVo.getId());
            dataSetsVo.setCreateTime(new Date());
            this.dataSetsVoList.add(0,dataSetsVo);
            return true;
        }
        return false;
    }
}
