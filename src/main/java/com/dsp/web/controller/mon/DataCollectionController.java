package com.dsp.web.controller.mon;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.mon.DataCollection;
import com.dsp.web.model.mon.DataCollectionParam;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.monitorCenter.DataCollectionService;
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
public class DataCollectionController {
    @Autowired
    private DataCollectionService monitorCenterService;

    @RequestMapping(value = "/querySearchList",method = RequestMethod.POST)
    public ResponseResult<DataCollection> querySearchList(@RequestBody DataCollectionParam onSearchParam) throws Exception {
        ResponseResult<DataCollection> result = new ResponseResult<>();
        try {
            //BatchAuth batchAuth = new BatchAuth();
            List<DataCollection> onSearchList = new ArrayList<>();

            //查询参数
            String sqlId = onSearchParam.getSqlId();
            String name = onSearchParam.getName();
            String resource = onSearchParam.getResource();
            int currentPage = onSearchParam.getCurrentPage();
            int pageSize = onSearchParam.getPageSize();

            String message = "";
            try {
                onSearchList = monitorCenterService.getSearchList(sqlId, name, resource, currentPage, pageSize);
                int count = monitorCenterService.getSearchCount(sqlId, name, resource);
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
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

}
