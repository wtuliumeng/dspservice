package com.dsp.web.service.configCenter;

import com.dsp.web.model.configCenter.*;

import java.util.List;

public interface ConfigCenterService {
    //用户配置
    List<BatchAuth> getUserConfigList(String userName, String IPAddr, String status, int currentPage, int pageSize);

    int getUserConfigCount(String userName, String IPAddr, String status);

    boolean addUserConfig(BatchAuth batchAuthVo);

    boolean updateUserConfig(BatchAuth batchAuthVo);

    boolean deleteUserConfig(String userName);

    boolean deleteUserConfigBatch(List<String> userNames);

    //异步任务配置
    List<BatchSql> getAsyncTaskList(BatchSqlQueryParam batchSqlQueryParam);

    int getAsyncTaskCount(BatchSqlQueryParam batchSqlQueryParam);

    boolean addAsyncTask(BatchSql batchSqlVo);

    boolean updateAsyncTask(BatchSql batchSqlVo);

    boolean deleteAsyncTask(String sqlId);

    boolean deleteAsyncTaskBatch(List<String> sqlIds);

    //同步任务配置
    List<BatchRtq> getSyncTaskList(BatchRtqQueryParam batchRtqQueryParam);

    int getSyncTaskCount(BatchRtqQueryParam batchRtqQueryParam);

    boolean addSyncTask(BatchRtq batchRtqVo);

    boolean updateSyncTask(BatchRtq batchRtqVo);

    boolean deleteSyncTask(String sqlId);

    boolean deleteSyncTaskBatch(List<String> sqlIds);
}
