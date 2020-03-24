package com.dsp.web.controller.datamanage;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.datamanage.DataSetsParam;
import com.dsp.web.model.datamanage.DataSets;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.datamanage.DataSetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/data-server-api")
public class DataServerController {

    @Autowired
    private DataSetsService dataSetsService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResponseResult<DataSets> list(@RequestBody DataSetsParam dataSetsParam){
        ResponseResult<DataSets> result = new ResponseResult<>();
        try {
            //获取用户标识
            String userId = dataSetsParam.getUserId();
            if(StringUtils.isEmpty(userId)){
                result.setStatus(Status.FAILED);
                result.setMessage("当前用户不存在");
            }
            //查询数据总量
            Long count = dataSetsService.getDataSetsCount(dataSetsParam);
            //查询数据列表
            List<DataSets> dataSetsVoList = new ArrayList<>(count.intValue());
            if(count > 0){
                //有数据则去数据库进行查询
                dataSetsVoList = dataSetsService.getDataSetsList(dataSetsParam);
            }
            //封装数据
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            result.setCount(count.intValue());
            result.setDataList(dataSetsVoList);
            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseResult<DataSets> add(@RequestBody DataSets dataSetsVo){
        ResponseResult<DataSets> result = new ResponseResult<>();
        try {
            //数据校验
            if(dataSetsVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            if(StringUtils.isEmpty(dataSetsVo.getId())){
                result.setStatus(Status.FAILED);
                result.setMessage("数据集标识为空");
            }
            if(StringUtils.isEmpty(dataSetsVo.getName())){
                result.setStatus(Status.FAILED);
                result.setMessage("数据集名称为空");
            }
            //更新创建时间和更新时间
            dataSetsVo.setCreateTime(new Date());
            dataSetsVo.setUpdateTime(new Date());
            //插入数据
            boolean flag = dataSetsService.add(dataSetsVo);
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
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseResult<DataSets> update(@RequestBody DataSets dataSetsVo){
        ResponseResult<DataSets> result = new ResponseResult<>();
        try {
            //数据校验
            if(dataSetsVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            if(StringUtils.isEmpty(dataSetsVo.getName())){
                result.setStatus(Status.FAILED);
                result.setMessage("数据集名称为空");
            }
            if(StringUtils.isEmpty(dataSetsVo.getId())){
                result.setStatus(Status.FAILED);
                result.setMessage("数据集标识为空");
            }
            //更新更新时间
            dataSetsVo.setUpdateTime(new Date());
            //更新数据
            boolean flag = dataSetsService.update(dataSetsVo);
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("更新成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("更新库失败");
            }

            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseResult<DataSets> delete(@RequestBody DataSets dataSetsVo){
        ResponseResult<DataSets> result = new ResponseResult<>();
        try {
            //数据校验
            if(dataSetsVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            if(StringUtils.isEmpty(dataSetsVo.getId())){
                result.setStatus(Status.FAILED);
                result.setMessage("数据集标识为空");
            }
            //删除数据
            boolean flag = dataSetsService.delete(dataSetsVo.getId());
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("删除成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("从库中删除失败");
            }

            //返回数据实体
            return result;
        }catch (Exception ex){
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

    @RequestMapping(value = "/deleteBatch",method = RequestMethod.POST)
    public ResponseResult<DataSets> deleteBatch(@RequestBody DataSets dataSetsVo){
        ResponseResult<DataSets> result = new ResponseResult<>();
        try {
            //数据校验
            if(dataSetsVo==null){
                result.setStatus(Status.FAILED);
                result.setMessage("提交数据为空");
            }
            if(dataSetsVo.getIds()==null || dataSetsVo.getIds().size() <= 0){
                result.setStatus(Status.FAILED);
                result.setMessage("数据集标识为空");
            }
            //删除数据
            boolean flag = dataSetsService.deleteBatch(dataSetsVo.getIds());
            if(flag){
                //封装数据
                result.setStatus(Status.SUCCESS);
                result.setMessage("批量删除成功");
            }else{
                //封装数据
                result.setStatus(Status.FAILED);
                result.setMessage("批量从库中删除失败");
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
