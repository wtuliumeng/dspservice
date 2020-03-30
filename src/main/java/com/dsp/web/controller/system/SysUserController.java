package com.dsp.web.controller.system;

import com.dsp.web.common.enums.Status;
import com.dsp.web.common.utils.EncryptUtil;
import com.dsp.web.model.system.SysUserParam;
import com.dsp.web.model.system.SysUserVo;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
@RestController
@RequestMapping(value="/sysuser-api")
public class SysUserController {


    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseResult<Object> addUser(@RequestBody SysUserVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            if(vo!=null&&vo.getId()>0)
            {
                if("0".equals(vo.getLock())){
                    vo.setPassword("");
                }
                sysUserService.updateSysUser(vo);
                result.setStatus(Status.SUCCESS);
                result.setMessage("更新成功");
            }
            else
            {
                sysUserService.insertSysUser(vo);
                result.setStatus(Status.SUCCESS);
                result.setMessage("新增成功");
            }
            return result;
        }catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @RequestMapping(value = "/querySysUser",method = RequestMethod.POST)
    public ResponseResult<SysUserVo> querySysUser(@RequestParam("id") String id)throws Exception {
        ResponseResult<SysUserVo> result = new ResponseResult<>();
        try {
            if(id!=null && id.length()!=0) {

                result = sysUserService.querySysUserByPrimaryKey(id);
            }
            else
            {
                result.setStatus(Status.FAILED);
                result.setMessage("执行异常,参数不完整");
            }
            return result;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @RequestMapping(value = "/querySysUserList",method = RequestMethod.POST)
    public ResponseResult<SysUserVo> querySysUserList(@RequestBody SysUserParam vo)throws Exception {
        ResponseResult<SysUserVo> result = new ResponseResult<>();
        try {
            List<SysUserVo> sysUserVos = sysUserService.querySysUserList(vo);
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            result.setDataList(sysUserVos);
            return result;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @RequestMapping(value = "/delSysUserByUserId",method = RequestMethod.POST)
    public ResponseResult<Object> delSysUserByUserId(@RequestParam("ids") String ids)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            if(ids!=null&&!ids.equals(""))
            {
                sysUserService.delSysUserByUserId(ids);
                result.setMessage("修改成功");
                result.setStatus(Status.SUCCESS);
            }
            else
            {
                result.setMessage("修改失败");
                result.setStatus(Status.FAILED);
            }
            return result;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @RequestMapping(value = "/checkOldPassWord",method = RequestMethod.POST)
    public ResponseResult<Object> checkOldPassWord(@RequestParam("LoginName") String LoginName,@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {


            if(LoginName!=null&&!LoginName.equals(""))
            {
                result= sysUserService.checkOldPassWord(LoginName,oldPassword,newPassword);
            }
            else
            {
                result.setMessage("用户名不能为空");
                result.setStatus(Status.FAILED);
            }
            return result;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
}
