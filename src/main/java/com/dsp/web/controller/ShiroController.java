package com.dsp.web.controller;

import com.dsp.web.common.enums.Status;
import com.dsp.web.common.utils.EncryptUtil;
import com.dsp.web.model.shiro.*;
import com.dsp.web.model.vo.Response;
import com.dsp.web.model.vo.ResponseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/shiro-api")
public class ShiroController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseResult<LoginInfoVo> login(@RequestBody UserInfoParam userInfoParam) throws Exception {
        ResponseResult<LoginInfoVo> result = new ResponseResult<>();
        try {
            LoginInfoVo loginInfoVo=new LoginInfoVo();
            String loginName=userInfoParam.getLoginName();
//            String passWord="123456";//前端加密了
            String passWord=userInfoParam.getPassword();
            Subject subject = SecurityUtils.getSubject();
            //subject.logout();
            //加密
            //String encryptPwd= EncryptUtil.encryptPwd(passWord);
            UsernamePasswordToken token = new UsernamePasswordToken(loginName,passWord);
            String message="";
            try {
                subject.login(token);
                message="登陆成功";
                //log.info(message);
                //设置用户信息
                UserInfo userInfo=new UserInfo();
                BeanUtils.copyProperties(subject.getPrincipal(),userInfo);

                userInfo.setPassword(null);
                userInfo.setSalt(null);
                userInfo.setToken(subject.getSession().getId().toString());
                loginInfoVo.setUserInfo(userInfo);
                //ResponseResult<LoginInfoVo> response= sysUserServiceFeign.getLoginInfoByUserId(userInfo.getUserId().toString());
                ResponseResult<LoginInfoVo> response= new ResponseResult<>();
                /*造假数据*/
                userInfo.setUserName("admin");
                response.setStatus(Status.SUCCESS);
                List<SysRoleVo> sysRoleVoList = new ArrayList<>();
                SysRoleVo sysRoleVo = new SysRoleVo();
                sysRoleVo.setRoleName("管理员");
                sysRoleVoList.add(sysRoleVo);

                List<RolePermissionVo> rolePermissionVoList = new ArrayList<>();
                RolePermissionVo rolePermissionVo1 = new RolePermissionVo();
                rolePermissionVo1.setPermission("liuyan_add");
                rolePermissionVo1.setResoureName("添加");
                RolePermissionVo rolePermissionVo2 = new RolePermissionVo();
                rolePermissionVo2.setPermission("liuyan_select");
                rolePermissionVo2.setResoureName("查询");
                rolePermissionVoList.add(rolePermissionVo1);
                rolePermissionVoList.add(rolePermissionVo2);

                List<SysMenuVo> sysMenuVoList = new ArrayList<>();
                SysMenuVo sysMenuVo1 = new SysMenuVo();
                sysMenuVo1.setId(1L);
                sysMenuVo1.setMenuName("系统首页");
                sysMenuVo1.setMenuIcon("el-icon-tickets");
                sysMenuVo1.setParentId("0");
                sysMenuVo1.setOrderBy("1");
                sysMenuVo1.setIsShow(1);
                sysMenuVo1.setResoure_url("index");
                sysMenuVo1.setResoure_type("module");
                sysMenuVo1.setPermission("index");
                List<SysMenuVo> sysMenuVoChildList1 = new ArrayList<>();
                SysMenuVo sysMenuVoChild1 = new SysMenuVo();
                sysMenuVoChild1.setId(11L);
                sysMenuVoChild1.setMenuName("首页");
                sysMenuVoChild1.setParentId("1");
                sysMenuVoChild1.setOrderBy("1");
                sysMenuVoChild1.setIsShow(1);
                sysMenuVoChild1.setResoure_type("url");
                sysMenuVoChild1.setPermission("index");
                sysMenuVoChildList1.add(sysMenuVoChild1);
                sysMenuVo1.setSysMenuVoChild(sysMenuVoChildList1);

                sysMenuVoList.add(sysMenuVo1);

                loginInfoVo.setRolePermissionVoList(rolePermissionVoList);
                loginInfoVo.setSysRoleVoList(sysRoleVoList);
                loginInfoVo.setSysMenuVoList(sysMenuVoList);


                response.setData(loginInfoVo);
                if(ResponseResult.isSucess(response)){
                    LoginInfoVo loginInfoDTO=response.getData();
                    loginInfoVo.setSysRoleVoList(loginInfoDTO.getSysRoleVoList());
                    loginInfoVo.setRolePermissionVoList(loginInfoDTO.getRolePermissionVoList());
                    loginInfoVo.setSysMenuVoList(loginInfoDTO.getSysMenuVoList());
                }
                else{
                    String errorMsg=MessageFormat.format("login.getLoginInfoByUserId.error,userid:{0}",userInfo.getUserId().toString());
                    //log.error(errorMsg);
                    throw new Exception(errorMsg);
                }

                result.setData(loginInfoVo);
                result.setStatus(Status.SUCCESS);
            } catch (IncorrectCredentialsException e) {
                result.setStatus(Status.FAILED);
                message="密码错误";
                //log.info(message);
            } catch (LockedAccountException e) {
                result.setStatus(Status.FAILED);
                message="登录失败，该用户已被冻结";
                //log.info(message);
                //log.error(e.getMessage(),e);
            } catch (AuthenticationException e) {
                result.setStatus(Status.FAILED);
                message="该用户不存在";
                //log.info("该用户不存在");
            } catch (Exception e) {
                result.setStatus(Status.FAILED);
                message="登录异常";
                //log.error(message);
                //log.error(e.getMessage(),e);
            }
            result.setMessage(message);
            //SecurityUtils.getSubject().getSession().setTimeout(shiroRedis.getExpiretime());
            return result;
        }
        catch (Exception ex){
            //log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

    /**
     * 未登录
     * @return
     */
    @RequestMapping(value = "/unlogin",method = {RequestMethod.POST, RequestMethod.GET})
    public Response unlogin() {
        Response result=new Response();
        result.setMessage("未登录");
        result.setStatus(Status.FAILED);
        return result;
    }

    /**
     * 未授权
     * @return
     */
    @RequestMapping(value = "/unauth",method = {RequestMethod.POST, RequestMethod.GET})
    public Response unauth() {
        Response result=new Response();
        result.setMessage("未授权");
        result.setStatus(Status.FAILED);
        return result;
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "/loginout",method = {RequestMethod.POST, RequestMethod.GET})
    public Response logout() {
        Response result=new Response();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            result.setMessage("退出登录");
            result.setStatus(Status.SUCCESS);
            return result;
        }
        catch (Exception ex){
            result.setMessage("退出失败");
            result.setStatus(Status.FAILED);
            return result;
        }
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "/test",method = {RequestMethod.POST, RequestMethod.GET})
    @RequiresPermissions("workfile/queryCreditIntoInfo:exportExcel")
    public Response test() {
        Response result=new Response();
        result.setMessage("测试权限通过");
        result.setStatus(Status.SUCCESS);
        return result;
    }

}
