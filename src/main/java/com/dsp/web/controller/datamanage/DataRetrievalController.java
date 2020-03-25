package com.dsp.web.controller.datamanage;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.datamanage.DataRetrievalParam;
import com.dsp.web.model.datamanage.DataRetrievalVo;
import com.dsp.web.model.datamanage.FileRetrieval;
import com.dsp.web.model.datamanage.FileRetrievalParam;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.datamanage.DataRetrievalService;
import com.dsp.web.service.datamanage.FileRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/data-retrieval-api")
public class DataRetrievalController {


    @Autowired
    private DataRetrievalService dataRetrievalService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResponseResult<DataRetrievalVo> list(@RequestBody DataRetrievalParam param){
        ResponseResult<DataRetrievalVo> result = new ResponseResult<>();
        try {
            //获取
            String userId = param.getUserId();
            if(StringUtils.isEmpty(userId)){
                result.setStatus(Status.FAILED);
                result.setMessage("当前用户不存在");
                //返回数据实体
                return result;
            }
            if(StringUtils.isEmpty(param.getSqlId())){
                result.setStatus(Status.FAILED);
                result.setMessage("sql编号不允许为空");
                //返回数据实体
                return result;
            }
            if(StringUtils.isEmpty(param.getDate())){
                result.setStatus(Status.FAILED);
                result.setMessage("运行日期不允许为空");
                //返回数据实体
                return result;
            }
            //查询表格数据
            DataRetrievalVo dataRetrievalVo = dataRetrievalService.getTableList(param);
            if(dataRetrievalVo == null){
                result.setStatus(Status.FAILED);
                result.setMessage("sql编号未找到");
                //返回数据实体
                return result;
            }
            //封装数据
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            result.setCount(dataRetrievalVo.getCount().intValue());
            result.setData(dataRetrievalVo);
            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

}
