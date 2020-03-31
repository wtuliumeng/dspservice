package com.dsp.web.controller.system;


import com.dsp.web.common.enums.Status;
import com.dsp.web.model.system.SysOrgParam;
import com.dsp.web.model.system.SysOrgVo;
import com.dsp.web.model.system.TreeNodeVo;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.system.SysOrgService;
import com.sun.xml.internal.ws.util.pipe.StandaloneTubeAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Administrator on 2018/6/27.
 */

@RestController
@RequestMapping(value="/sysorg-api")
public class SysOrgController {

    @Autowired
    private SysOrgService sysOrgService;

    @RequestMapping(value = "/addOrg",method = RequestMethod.POST)
    public ResponseResult<Object> addOrg(@RequestBody SysOrgVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            if(vo!=null&&vo.getId()>0)
            {
                sysOrgService.updateSysOrg(vo);
                result.setMessage("更新成功");
            }
            else
            {
                sysOrgService.insertSysOrg(vo);
                result.setMessage("新增成功");
            }
            result.setStatus(Status.SUCCESS);
            return result;
        }catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    
    @RequestMapping(value = "/querySysOrgList",method = RequestMethod.POST)
    public ResponseResult<List<TreeNodeVo>> querySysOrgList(@RequestBody SysOrgParam vo)throws Exception {
        ResponseResult<List<TreeNodeVo>> resulttree = new ResponseResult<>();
        try {
            List<SysOrgVo> sysOrgVoList =sysOrgService.querySysOrgList(vo);
            resulttree.setData(SysOrgVo.ToTreeModel(sysOrgVoList));
            resulttree.setStatus(Status.SUCCESS);
            return resulttree;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            resulttree.setStatus(Status.FAILED);
            resulttree.setMessage("执行异常,请重试");
            return resulttree;

        }
    }

    @RequestMapping(value = "/querySysOrg",method = RequestMethod.POST)
    public ResponseResult<Object> querySysOrg(@RequestParam("") String orgid)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            SysOrgVo sysOrgVo = sysOrgService.querySysOrgByPrimaryKey(orgid);
            result.setData(sysOrgVo);
            result.setMessage("查询成功");
            result.setStatus(Status.SUCCESS);
            return result;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    
    @RequestMapping(value = "/deleteSysOrg",method = RequestMethod.POST)
    public ResponseResult deleteSysOrg(@RequestParam("") String orgid)throws Exception {
        ResponseResult result = new ResponseResult<>();
        try {
            sysOrgService.deleteOrgByID(orgid);
            result.setStatus(Status.SUCCESS);
            result.setMessage("删除成功");
            return result;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }


}
