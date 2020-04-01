package com.dsp.web.controller.mon;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.mon.RealCall;
import com.dsp.web.model.mon.RealCallParam;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.monitorCenter.RealCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhouyang on 2020/3/26.
 */
@RestController
@RequestMapping(value="/mon-api")
public class RealCallController {
    @Autowired
    private RealCallService dataSearchService;

    @RequestMapping(value = "/dataSearchList",method = RequestMethod.POST)
    public ResponseResult<RealCall> dataSearchList(@RequestBody RealCallParam querySearchParam) throws Exception {
        ResponseResult<RealCall> result = new ResponseResult<>();
        try {
            //BatchAuth batchAuth = new BatchAuth();
            List<RealCall> querySearchArrayList = new ArrayList<>();

            //查询参数
            String querynumber = querySearchParam.getQuerynumber();
            String tasknumber = querySearchParam.getTasknumber();
            String callsystem = querySearchParam.getCallsystem();
            String status=querySearchParam.getStatus();
            Date rundate=querySearchParam.getRundate();
            int currentPage = querySearchParam.getCurrentPage();
            int pageSize = querySearchParam.getPageSize();

            String message = "";
            try {
                querySearchArrayList = dataSearchService.getdataSearchList(querynumber, tasknumber, callsystem, status,rundate,currentPage, pageSize);
                int count = dataSearchService.getdataSearchCount(querynumber, tasknumber, callsystem, status,rundate);
                result.setCount(count);
                message = "查询用户配置成功";
                result.setDataList(querySearchArrayList);
                result.setStatus(Status.SUCCESS);
                System.out.println(currentPage);
                System.out.println(pageSize);
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
