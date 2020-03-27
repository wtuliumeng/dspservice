package com.dsp.web.controller.configCenter;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.configCenter.*;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.configCenter.ConfigCenterService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/configCenter-api")
public class ConfigCenterController {

    @Autowired
    private ConfigCenterService configCenterService;

    @RequestMapping(value = "/queryUserConfigList",method = RequestMethod.POST)
    public ResponseResult<BatchAuth> queryUserConfigList(@RequestBody BatchAuthQueryParam batchAuthQueryParam) throws Exception {
        ResponseResult<BatchAuth> result = new ResponseResult<>();
        try {
            //BatchAuth batchAuth = new BatchAuth();
            List<BatchAuth> batchAuthList = new ArrayList<>();

            //查询参数
            String userName = batchAuthQueryParam.getUserName();
            String IPAddr = batchAuthQueryParam.getIPAddr();
            String status = batchAuthQueryParam.getStatus();
            int currentPage = batchAuthQueryParam.getCurrentPage();
            int pageSize = batchAuthQueryParam.getPageSize();

            String message = "";
            try {
                int count = configCenterService.getUserConfigCount(userName, IPAddr, status);
                if (count > 0) {
                    batchAuthList = configCenterService.getUserConfigList(userName, IPAddr, status, currentPage, pageSize);

                }
                result.setCount(count);
                message = "查询用户配置成功";
                result.setDataList(batchAuthList);
                result.setStatus(Status.SUCCESS);
            } catch (Exception e) {
                result.setStatus(Status.FAILED);
                message = "查询用户配置异常";
            }
            result.setMessage(message);
            return result;
        } catch (Exception ex) {
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @RequestMapping(value = "/addUserConfig",method = RequestMethod.POST)
    public ResponseResult<BatchAuth> addUserConfig(@RequestBody BatchAuth batchAuthVo) throws Exception {
        ResponseResult<BatchAuth> result = new ResponseResult<>();
        try {//数据校验
            if(batchAuthVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }

            Date dateTime = new Date();
            //更新创建时间和更新时间
            batchAuthVo.setCreateTime(dateTime.toString());
            batchAuthVo.setUpdateTime(dateTime.toString());
            //插入数据
            boolean flag = configCenterService.addUserConfig(batchAuthVo);
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("查询成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("插库失败");
            }
            //返回数据实体
            return result;
        }
        catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @RequestMapping(value = "/updateUserConfig",method = RequestMethod.POST)
    public ResponseResult<BatchAuth> updateUserConfig(@RequestBody BatchAuth batchAuthVo){
        ResponseResult<BatchAuth> result = new ResponseResult<>();
        try {
            //数据校验
            if(batchAuthVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            //更新更新时间
            batchAuthVo.setUpdateTime((new Date()).toString());
            //更新数据
            boolean flag = configCenterService.updateUserConfig(batchAuthVo);
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("更新用户配置成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("更新用户配置失败");
            }

            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @RequestMapping(value = "/deleteUserConfig",method = RequestMethod.POST)
    public ResponseResult<BatchAuth> deleteUserConfig(@RequestBody BatchAuth BatchAuthVo){
        ResponseResult<BatchAuth> result = new ResponseResult<>();
        try {
            //数据校验
            if(BatchAuthVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            //删除数据
            boolean flag = configCenterService.deleteUserConfig(BatchAuthVo.getUserName());
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("删除用户配置成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("从库中删除用户配置失败");
            }
            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

    @RequestMapping(value = "/deleteUserConfigBatch",method = RequestMethod.POST)
    public ResponseResult<BatchAuth> deleteUserConfigBatch(@RequestBody BatchAuth batchAuthVo){
        ResponseResult<BatchAuth> result = new ResponseResult<>();
        try {
            //数据校验
            if(batchAuthVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            //删除数据
            boolean flag = configCenterService.deleteUserConfigBatch(batchAuthVo.getUserNames());
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("批量删除用户配置成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("批量从库中删除用户配置失败");
            }

            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }


    @RequestMapping(value = "/queryAsyncTaskList",method = RequestMethod.POST)
    public ResponseResult<BatchSql> queryAsyncTaskList(@RequestBody BatchSqlQueryParam batchSqlQueryParam) throws Exception {
        ResponseResult<BatchSql> result = new ResponseResult<>();
        try {
            List<BatchSql> BatchSqlList = new ArrayList<>();

            String message = "";
            try {
                int count = configCenterService.getAsyncTaskCount(batchSqlQueryParam);
                if (count > 0) {
                    BatchSqlList = configCenterService.getAsyncTaskList(batchSqlQueryParam);

                }
                result.setCount(count);
                message = "查询用户配置成功";
                result.setDataList(BatchSqlList);
                result.setStatus(Status.SUCCESS);
            } catch (Exception e) {
                result.setStatus(Status.FAILED);
                message = "查询用户配置异常";
            }
            result.setMessage(message);
            return result;
        } catch (Exception ex) {
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @RequestMapping(value = "/addAsyncTask",method = RequestMethod.POST)
    public ResponseResult<BatchSql> addAsyncTask(@RequestBody BatchSql batchSqlVo) throws Exception {
        ResponseResult<BatchSql> result = new ResponseResult<>();
        try {//数据校验
            if(batchSqlVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }

            //插入数据
            boolean flag = configCenterService.addAsyncTask(batchSqlVo);
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("异步任务入库成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("异步任务入库失败");
            }
            //返回数据实体
            return result;
        }
        catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @RequestMapping(value = "/updateAsyncTask",method = RequestMethod.POST)
    public ResponseResult<BatchSql> updateAsyncTask(@RequestBody BatchSql batchSqlVo){
        ResponseResult<BatchSql> result = new ResponseResult<>();
        try {
            //数据校验
            if(batchSqlVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            //更新数据
            boolean flag = configCenterService.updateAsyncTask(batchSqlVo);
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("更新异步任务成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("更新异步任务失败");
            }

            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @RequestMapping(value = "/deleteAsyncTask",method = RequestMethod.POST)
    public ResponseResult<BatchSql> deleteAsyncTask(@RequestBody BatchSql batchSqlVo){
        ResponseResult<BatchSql> result = new ResponseResult<>();
        try {
            //数据校验
            if(batchSqlVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            //删除数据
            boolean flag = configCenterService.deleteAsyncTask(batchSqlVo.getSqlId());
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("删除异步任务成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("删除异步任务失败");
            }
            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

    @RequestMapping(value = "/deleteAsyncTaskBatch",method = RequestMethod.POST)
    public ResponseResult<BatchSql> deleteAsyncTaskBatch(@RequestBody BatchSql batchSqlVo){
        ResponseResult<BatchSql> result = new ResponseResult<>();
        try {
            //数据校验
            if(batchSqlVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            //删除数据
            boolean flag = configCenterService.deleteAsyncTaskBatch(batchSqlVo.getSqlIds());
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("批量异步任务配置成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("批量删除异步任务配置失败");
            }

            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }



    @RequestMapping(value = "/querySyncTaskList",method = RequestMethod.POST)
    public ResponseResult<BatchRtq> querySyncTaskList(@RequestBody BatchRtqQueryParam BatchRtqQueryParam) throws Exception {
        ResponseResult<BatchRtq> result = new ResponseResult<>();
        try {
            List<BatchRtq> BatchRtqList = new ArrayList<>();

            String message = "";
            try {
                int count = configCenterService.getSyncTaskCount(BatchRtqQueryParam);
                if (count > 0) {
                    BatchRtqList = configCenterService.getSyncTaskList(BatchRtqQueryParam);

                }
                result.setCount(count);
                message = "查询用户配置成功";
                result.setDataList(BatchRtqList);
                result.setStatus(Status.SUCCESS);
            } catch (Exception e) {
                result.setStatus(Status.FAILED);
                message = "查询用户配置异常";
            }
            result.setMessage(message);
            return result;
        } catch (Exception ex) {
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @RequestMapping(value = "/addSyncTask",method = RequestMethod.POST)
    public ResponseResult<BatchRtq> addSyncTask(@RequestBody BatchRtq batchRtqVo) throws Exception {
        ResponseResult<BatchRtq> result = new ResponseResult<>();
        try {//数据校验
            if(batchRtqVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }

            //插入数据
            boolean flag = configCenterService.addSyncTask(batchRtqVo);
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("同步任务入库成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("同步任务入库失败");
            }
            //返回数据实体
            return result;
        }
        catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @RequestMapping(value = "/updateSyncTask",method = RequestMethod.POST)
    public ResponseResult<BatchRtq> updateSyncTask(@RequestBody BatchRtq batchRtqVo){
        ResponseResult<BatchRtq> result = new ResponseResult<>();
        try {
            //数据校验
            if(batchRtqVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            //更新数据
            boolean flag = configCenterService.updateSyncTask(batchRtqVo);
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("更新同步任务成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("更新同步任务失败");
            }

            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @RequestMapping(value = "/deleteSyncTask",method = RequestMethod.POST)
    public ResponseResult<BatchRtq> deleteSyncTask(@RequestBody BatchRtq batchRtqVo){
        ResponseResult<BatchRtq> result = new ResponseResult<>();
        try {
            //数据校验
            if(batchRtqVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            //删除数据
            boolean flag = configCenterService.deleteSyncTask(batchRtqVo.getSqlId());
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("删除同步任务成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("删除同步任务失败");
            }
            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

    @RequestMapping(value = "/deleteSyncTaskBatch",method = RequestMethod.POST)
    public ResponseResult<BatchRtq> deleteSyncTaskBatch(@RequestBody BatchRtq batchRtqVo){
        ResponseResult<BatchRtq> result = new ResponseResult<>();
        try {
            //数据校验
            if(batchRtqVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            //删除数据
            boolean flag = configCenterService.deleteSyncTaskBatch(batchRtqVo.getSqlIds());
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("批量同步任务配置成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("批量删除同步任务配置失败");
            }

            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
}