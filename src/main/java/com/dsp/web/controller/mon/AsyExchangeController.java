package com.dsp.web.controller.mon;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.mon.AsyExchange;
import com.dsp.web.model.mon.AsyExchangeParam;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.monitorCenter.AsyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhouyang on 2020/3/24.
 */

@RestController
@RequestMapping(value="/mon-api")
public class AsyExchangeController {
    @Autowired
    private AsyExchangeService queryDataSearchService;

    @RequestMapping(value = "/queryDataSearchList",method = RequestMethod.POST)
    public ResponseResult<AsyExchange> queryDataSearchList(@RequestBody AsyExchangeParam dataSearchParam) throws Exception {
        ResponseResult<AsyExchange> result = new ResponseResult<>();
        try {
            //BatchAuth batchAuth = new BatchAuth();
            List<AsyExchange> dataSearchList = new ArrayList<>();

            //查询参数
            String name = dataSearchParam.getName();
            String sqlname = dataSearchParam.getSqlname();
            String switcsystem = dataSearchParam.getSwitcsystem();
            String resource=dataSearchParam.getResource();
            Date rundate=dataSearchParam.getRundate();
            int currentPage = dataSearchParam.getCurrentPage();
            int pageSize = dataSearchParam.getPageSize();

            String message = "";
            try {
                dataSearchList = queryDataSearchService.getquerySearchList(name, sqlname, switcsystem, resource,rundate,currentPage, pageSize);
                int count = queryDataSearchService.getquerySearchCount(name, sqlname, switcsystem, resource,rundate);
                result.setCount(count);
                message = "查询用户配置成功";
                result.setDataList(dataSearchList);
                result.setStatus(Status.SUCCESS);
                //System.out.println(currentPage);
                //System.out.println(pageSize);
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
