package com.dsp.web.service.configCenter.impl;

import com.dsp.web.model.configCenter.*;
import com.dsp.web.service.configCenter.ConfigCenterService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigCenterServiceImpl implements ConfigCenterService {

    /*造假数据*/
    private List<BatchAuth> batchAuthVoList = new ArrayList<>();
    private List<BatchRtq> batchRtqVoList = new ArrayList<>();
    private List<BatchSql> batchSqlVoList = new ArrayList<>();

    @Override
    public List<BatchAuth> getUserConfigList(String userName, String IPAddr, String status, int currentPage, int pageSize) {

        /*造假数据*/
        List<BatchAuth> batchAuthVoList1 = new ArrayList<>();
        for(int i = (currentPage-1)*pageSize;i<this.batchAuthVoList.size();i++){
            batchAuthVoList1.add(this.batchAuthVoList.get(i));
            if(batchAuthVoList1.size()==pageSize){
                break;
            }
        }
        return batchAuthVoList1;
    }

    @Override
    public int getUserConfigCount(String userName, String IPAddr, String status) {
        /*造假数据*/
        if(this.batchAuthVoList.size() <= 0){
            //如果没有数据，则插入16条假数据
            for(int i = 0 ; i < 16 ;i++){
                BatchAuth batchAuth = new BatchAuth();
                batchAuth.setAuthTime("" + i);
                batchAuth.setCreateTime("" + i);
                batchAuth.setExpireTime("" + i);
                batchAuth.setIpAddr("ip" + i);
                batchAuth.setIssuer("" + i);
                batchAuth.setPassword("" + i);
                batchAuth.setSalt("" + i);
                batchAuth.setService("" + i);
                batchAuth.setStatus(""+i%2);
                batchAuth.setTimeout("" + i);
                batchAuth.setToken("" + i);
                batchAuth.setUpdateTime("" + i);
                batchAuth.setUserName("后台测试" + i);
                this.batchAuthVoList.add(batchAuth);
            }
        }
        return this.batchAuthVoList.size();
    }

    @Override
    public boolean addUserConfig(BatchAuth batchAuthVo) {
        if(batchAuthVo!=null){
            this.batchAuthVoList.add(0,batchAuthVo);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserConfig(BatchAuth batchAuthVo) {
        if(!StringUtils.isEmpty(batchAuthVo.getUserName())){
            this.deleteUserConfig(batchAuthVo.getUserName());
            this.batchAuthVoList.add(0,batchAuthVo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserConfig(String userName) {
        if(!StringUtils.isEmpty(userName)){
            for(int i = 0;i<this.batchAuthVoList.size();i++){
                if(this.batchAuthVoList.get(i).getUserName().equals(userName)){
                    this.batchAuthVoList.remove(i);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserConfigBatch(List<String> userNames) {
        boolean flag = true;
        for(int i = 0; i < userNames.size() ;i++){
            boolean rt = this.deleteUserConfig(userNames.get(i));
            if(!rt){
                flag = false;
            }
        }
        return flag;
    }




    @Override
    public List<BatchSql> getAsyncTaskList(BatchSqlQueryParam batchSqlQueryParam) {

        /*造假数据*/
        List<BatchSql> batchSqlVoList1 = new ArrayList<>();
        for(int i = (batchSqlQueryParam.getCurrentPage()-1)*batchSqlQueryParam.getPageSize();i<this.batchSqlVoList.size();i++){
            batchSqlVoList1.add(this.batchSqlVoList.get(i));
            if(batchSqlVoList1.size()==batchSqlQueryParam.getPageSize()){
                break;
            }
        }
        return batchSqlVoList1;
    }

    @Override
    public int getAsyncTaskCount(BatchSqlQueryParam batchSqlQueryParam) {
        /*造假数据*/
        if(this.batchSqlVoList.size() <= 0){
            //如果没有数据，则插入16条假数据
            for(int i = 0 ; i < 16 ;i++){
                BatchSql batchSql= new BatchSql();
                batchSql.setCsqlContext("" + i);
                batchSql.setDirName("" + i);
                batchSql.setParams("" + i);
                batchSql.setPlength("ip" + i);
                batchSql.setSqlContext("" + i);
                batchSql.setStatus("" + i);
                batchSql.setTableName("" + i);
                batchSql.setTsqlContext("" + i);
                batchSql.setSqlId("" + i);
                batchSql.setDbSource("" + i);
                batchSql.setUserName("后台测试" + i);
                this.batchSqlVoList.add(batchSql);
            }
        }
        return this.batchSqlVoList.size();
    }

    @Override
    public boolean addAsyncTask(BatchSql batchSqlVo) {
        if(batchSqlVo!=null){
            this.batchSqlVoList.add(0,batchSqlVo);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAsyncTask(BatchSql batchSqlVo) {
        if(!StringUtils.isEmpty(batchSqlVo.getSqlId())){
            this.deleteAsyncTask(batchSqlVo.getSqlId());
            this.batchSqlVoList.add(0,batchSqlVo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAsyncTask(String sqlId) {
        System.out.println(sqlId);System.out.println(sqlId);
        if(!StringUtils.isEmpty(sqlId)){
            for(int i = 0;i<this.batchSqlVoList.size();i++){
                if(this.batchSqlVoList.get(i).getSqlId().equals(sqlId)){
                    this.batchSqlVoList.remove(i);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAsyncTaskBatch(List<String> sqlIds) {
        boolean flag = true;
        for(int i = 0; i < sqlIds.size() ;i++){
            boolean rt = this.deleteAsyncTask(sqlIds.get(i));
            if(!rt){
                flag = false;
            }
        }
        return flag;
    }




    @Override
    public List<BatchRtq> getSyncTaskList(BatchRtqQueryParam batchRtqQueryParam) {

        /*造假数据*/
        List<BatchRtq> BatchRtqVoList1 = new ArrayList<>();
        for(int i = (batchRtqQueryParam.getCurrentPage()-1)*batchRtqQueryParam.getPageSize();i<this.batchRtqVoList.size();i++){
            BatchRtqVoList1.add(this.batchRtqVoList.get(i));
            if(BatchRtqVoList1.size()==batchRtqQueryParam.getPageSize()){
                break;
            }
        }
        return BatchRtqVoList1;
    }

    @Override
    public int getSyncTaskCount(BatchRtqQueryParam batchRtqQueryParam) {
        /*造假数据*/
        if(this.batchRtqVoList.size() <= 0){
            //如果没有数据，则插入16条假数据
            for(int i = 0 ; i < 16 ;i++){
                BatchRtq batchRtq= new BatchRtq();
                batchRtq.setCsqlContext("" + i);
                batchRtq.setListParamLimit("" + i);
                batchRtq.setParamCount("" + i);
                batchRtq.setParams("ip" + i);
                batchRtq.setSqlContext("" + i);
                batchRtq.setStatus("" + i);
                batchRtq.setTableName("" + i);
                batchRtq.setUserName("" + i);
                batchRtq.setSqlId(""+i%2);
                batchRtq.setDbSource("" + i);
                this.batchRtqVoList.add(batchRtq);
            }
        }
        return this.batchRtqVoList.size();
    }

    @Override
    public boolean addSyncTask(BatchRtq batchRtqVo) {
        if(batchRtqVo!=null){
            this.batchRtqVoList.add(0,batchRtqVo);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSyncTask(BatchRtq batchRtqVo) {
        if(!StringUtils.isEmpty(batchRtqVo.getSqlId())){
            this.deleteSyncTask(batchRtqVo.getSqlId());
            this.batchRtqVoList.add(0,batchRtqVo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSyncTask(String sqlId) {
        if(!StringUtils.isEmpty(sqlId)){
            for(int i = 0;i<this.batchRtqVoList.size();i++){
                if(this.batchRtqVoList.get(i).getSqlId().equals(sqlId)){
                    this.batchRtqVoList.remove(i);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSyncTaskBatch(List<String> sqlIds) {
        boolean flag = true;
        for(int i = 0; i < sqlIds.size() ;i++){
            boolean rt = this.deleteSyncTask(sqlIds.get(i));
            if(!rt){
                flag = false;
            }
        }
        return flag;
    }
}
