package com.dsp.web.controller.common;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.model.vo.SelectModelVo;
import com.dsp.web.service.common.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 获取拉下框的数据
 */
@RestController
@RequestMapping(value="/common-api")
public class SelectController {

    @Autowired
    private SelectService selectService;

    /**
     * 通过type类型进行下拉框数据获取
     * @param modelVo
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public ResponseResult<SelectModelVo> getSelectList(@RequestBody SelectModelVo modelVo) {
        ResponseResult<SelectModelVo> result = new ResponseResult<>();
        try{
            if(modelVo == null || StringUtils.isEmpty(modelVo.getType())){
                result.setStatus(Status.FAILED);
                result.setMessage("类型不能为空！");
                return result;
            }
            List<SelectModelVo> selectModelVoList = selectService.getSelectList(modelVo.getType());
            result.setStatus(Status.SUCCESS);
            result.setMessage("获取成功");
            result.setDataList(selectModelVoList);
            return result;
        }catch (Exception e){
            result.setStatus(Status.FAILED);
            result.setMessage("获取下拉框数据异常");
            //log.error("获取类型为" + type + "下拉框数据异常");
            return result;
        }
    }


    /**
     * 通过type类型进行下拉框数据获取
     * @param modelVo
     * @return
     */
    @RequestMapping(value = "/getLabel", method = RequestMethod.POST)
    public ResponseResult<SelectModelVo> getLabel(@RequestBody SelectModelVo modelVo) {
        ResponseResult<SelectModelVo> result = new ResponseResult<>();
        try{
            if(modelVo == null || StringUtils.isEmpty(modelVo.getType())|| StringUtils.isEmpty(modelVo.getValue())){
                result.setStatus(Status.FAILED);
                result.setMessage("类型和值不能为空！");
                return result;
            }
            SelectModelVo selectModel = selectService.getLabel(modelVo.getType(),modelVo.getValue());
            result.setStatus(Status.SUCCESS);
            result.setMessage("获取成功");
            result.setData(selectModel);
            return result;
        }catch (Exception e){
            result.setStatus(Status.FAILED);
            result.setMessage("获取Label数据异常");
            //log.error("获取类型为" + type + "值为" + value +  "label数据异常");
            return result;
        }
    }
}
