package com.dsp.web.controller.configCenter;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.configCenter.BatchAuth;
import com.dsp.web.model.configCenter.BatchAuthQueryParam;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.configCenter.ConfigCenterService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
                batchAuthList = configCenterService.getUserConfigList(userName, IPAddr, status, currentPage, pageSize);
                int count = configCenterService.getUserConfigCount(userName, IPAddr, status);

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
        }
        catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
}