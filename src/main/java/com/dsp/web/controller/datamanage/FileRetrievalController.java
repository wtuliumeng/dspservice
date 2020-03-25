package com.dsp.web.controller.datamanage;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.datamanage.DataSets;
import com.dsp.web.model.datamanage.DataSetsParam;
import com.dsp.web.model.datamanage.FileRetrieval;
import com.dsp.web.model.datamanage.FileRetrievalParam;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.datamanage.DataSetsService;
import com.dsp.web.service.datamanage.FileRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/file-server-api")
public class FileRetrievalController {


    @Autowired
    private FileRetrievalService fileRetrievalService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResponseResult<FileRetrieval> list(@RequestBody FileRetrievalParam param){
        ResponseResult<FileRetrieval> result = new ResponseResult<>();
        try {
            //获取
            String userId = param.getUserId();
            if(StringUtils.isEmpty(userId)){
                result.setStatus(Status.FAILED);
                result.setMessage("当前用户不存在");
                //返回数据实体
                return result;
            }
            //查询数据总量
            Long count = fileRetrievalService.getDataSetsCount(param);
            //查询数据列表
            List<FileRetrieval> fileRetrievalList = new ArrayList<>(count.intValue());
            if(count > 0){
                //有数据则去数据库进行查询
                fileRetrievalList = fileRetrievalService.getDataSetsList(param);
            }
            //封装数据
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            result.setCount(count.intValue());
            result.setDataList(fileRetrievalList);
            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

    @RequestMapping(value = "/searchFile",method = RequestMethod.POST)
    public ResponseResult<Map<String,String>> searchFile(@RequestBody FileRetrieval fileRetrieval){
        ResponseResult<Map<String,String>> result = new ResponseResult<>();
        try {
            //数据校验
            if(fileRetrieval == null){
                result.setStatus(Status.FAILED);
                result.setMessage("前端传送至后台数据为空");
                //返回数据实体
                return result;
            }
            if(StringUtils.isEmpty(fileRetrieval.getTaskId())
                    ||StringUtils.isEmpty(fileRetrieval.getFileName())){
                result.setStatus(Status.FAILED);
                result.setMessage("任务编号和文件名不能为空");
                //返回数据实体
                return result;
            }
            //查询文本数据
            Map<String,String> text = fileRetrievalService.getText(fileRetrieval.getTaskId(),fileRetrieval.getFileName());
            //封装数据
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            result.setData(text);
            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
}
