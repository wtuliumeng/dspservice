package com.dsp.web.controller.MonitorCenter;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.monitorCenter.OnSearch;
import com.dsp.web.model.monitorCenter.OnSearchParam;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.monitorCenter.MonitorCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouyang on 2020/3/24.
 */

@RestController
@RequestMapping(value="/mon-api")
public class MonitorCenterController {
    @Autowired
    private MonitorCenterService monitorCenterService;

    @RequestMapping(value = "/querySearchList",method = RequestMethod.POST)
    public ResponseResult<OnSearch> querySearchList(@RequestBody OnSearchParam onSearchParam) throws Exception {
        ResponseResult<OnSearch> result = new ResponseResult<>();
        System.out.println("test4");
        try {
            //BatchAuth batchAuth = new BatchAuth();
            List<OnSearch> onSearchList = new ArrayList<>();

            //查询参数
            String sqlId = onSearchParam.getSqlId();
            String name = onSearchParam.getName();
            String status = onSearchParam.getStatus();
            int currentPage = onSearchParam.getCurrentPage();
            int pageSize = onSearchParam.getPageSize();

            String message = "";
            try {
                onSearchList = monitorCenterService.getSearchList(sqlId, name, status, currentPage, pageSize);
                int count = monitorCenterService.getSearchCount(sqlId, name, status);
                result.setCount(count);
                message = "查询用户配置成功";
                result.setDataList(onSearchList);
                result.setStatus(Status.SUCCESS);
            } catch (Exception e) {
                result.setStatus(Status.FAILED);
                message = "查询用户配置异常";
            }
            result.setMessage(message);
            return result;
        }
        catch (Exception ex){
            System.out.println("test5");System.out.println(ex);

            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

}
