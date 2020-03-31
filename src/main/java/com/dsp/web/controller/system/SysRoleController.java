package com.dsp.web.controller.system;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.shiro.SysRole;
import com.dsp.web.model.system.SysRoleParam;
import com.dsp.web.model.system.SysRoleUserParam;
import com.dsp.web.model.system.SysRoleUserVo;
import com.dsp.web.model.system.SysRoleVo;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.system.SysRoleService;
import com.dsp.web.service.system.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

@RestController
@RequestMapping(value="/sysrole-api")
public class SysRoleController {
    
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleUserService sysRoleUserService;
    
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public ResponseResult<Object> addRole(@RequestBody SysRoleVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            if(vo!=null&&vo.getId()>0)
            {
                if(vo.getValidateState()==null){
                    vo.setValidateState("1");
                }
                vo.setVersion((long)1);
                boolean flag = sysRoleService.updateSysRole(vo);
                result.setStatus(Status.SUCCESS);
                result.setMessage("更新成功");
            }
            else
            {
                vo.setValidateState("1");
                vo.setVersion((long)1);
                boolean flag = sysRoleService.insertSysRole(vo);
                result.setStatus(Status.SUCCESS);
                result.setMessage("插入成功");
            }
            return result;
        }catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    
    @RequestMapping(value = "/getSysRoleByid",method = RequestMethod.POST)
    public ResponseResult<Object> getSysRoleByid(@RequestParam("id") String id)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {

            List<SysRole> sysRoleList =sysRoleService.querySysRoleByPrimaryKey(id);
            result.setData(sysRoleList);
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    
    @RequestMapping(value = "/deleteSysRoleByid",method = RequestMethod.POST)
    public ResponseResult<Object> deleteSysRoleByid(@RequestParam("id") String id)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            boolean flag = sysRoleService.deleteSysRolebyID(id);
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
    
    @RequestMapping(value = "/querySysRoleList",method = RequestMethod.POST)
    public ResponseResult<Object> querySysRoleList(@RequestBody SysRoleParam vo)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {

            List<SysRoleVo> roles =sysRoleService.querySysRoleList(vo);
            result.setData(roles);
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    
    @RequestMapping(value = "/saveRoleUser",method = RequestMethod.POST)
    public ResponseResult<Object> saveRoleUser(@RequestBody SysRoleUserVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            if(vo!=null&&vo.getId()>0)
            {
                vo.setTargetType("user");
                vo.setValidateState("1");
                boolean flag = sysRoleUserService.updateSysRoleUser(vo);
                result.setStatus(Status.SUCCESS);
                result.setMessage("更新成功");
            }
            else
            {
                vo.setTargetType("user");
                vo.setValidateState("1");
                boolean flag = sysRoleUserService.insertSysRoleUser(vo);
                result.setStatus(Status.SUCCESS);
                result.setMessage("插入成功");

            }
            return result;
        }catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    
    @RequestMapping(value = "/queryRoleUserList",method = RequestMethod.POST)
    public ResponseResult<Object> queryRoleUserList(@RequestBody SysRoleUserParam vo)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            List<SysRoleUserVo> sysRoleVos = sysRoleUserService.querySysRoleUserList(vo);
            result.setData(sysRoleVos);
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    
    @RequestMapping(value = "/deleteSysRoleUserByid",method = RequestMethod.POST)
    public ResponseResult<Object> deleteSysRoleUserByid(@RequestParam("id") String id)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            boolean flag = sysRoleUserService.deleteSysRoleUserbyID(id);
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
