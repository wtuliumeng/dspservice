package com.dsp.web.service.shiro;

import com.dsp.web.common.enums.Status;
import com.dsp.web.common.utils.DateUtil;
import com.dsp.web.common.utils.ListUtil;
import com.dsp.web.model.shiro.*;
import com.dsp.web.model.vo.ResponseResult;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义realm,登陆和权限
 */
public class MyShiroRealm extends AuthorizingRealm {
    /*@Autowired
    SysUserRest sysUserServiceFeign;
    @Autowired
    SysRoleRest sysRoleServiceFeign;
    @Autowired
    SysResourceRest sysResourceServiceFeign;*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
//        for (SysRole role : userInfo.getRoleList()) {
//            authorizationInfo.addRole(role.getRole());
//            for (SysPermission p : role.getPermissions()) {
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
        //authorizationInfo.addStringPermission("WF_HF_001");
        try {
            Set<String> roleCodeList = this.getRoleCodesByUserId(userInfo.getUserId());
            if (!ListUtil.isEmpty(roleCodeList)) {
                authorizationInfo.addRoles(roleCodeList);
            }
            Set<String> permissionList = this.getPermissionByUserId(userInfo.getUserId());
            if (!ListUtil.isEmpty(permissionList)) {
                authorizationInfo.addStringPermissions(permissionList);
            }
        }catch (Exception ex){
            //log.error("get permission error");
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        String loginName = (String) token.getPrincipal();

        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfoParam userInfoParam=new UserInfoParam();
        userInfoParam.setLoginName(loginName);
        ResponseResult<UserInfo> responseResult=new ResponseResult<>();
        try {
            //responseResult = sysUserServiceFeign.getUserInfoByLoginName(userInfoParam);
            /*创建假数据*/
            UserInfo userInfo = new UserInfo();
            userInfo.setLoginName("admin");
            userInfo.setPassword("admin123");
            responseResult.setData(userInfo);
            /*假数据创建结束*/
        }
        catch (Exception ex){
            throw new AuthenticationException(responseResult.getMessage());
        }
        if(ResponseResult.isSucess(responseResult)){
            UserInfo userInfo=responseResult.getData();

            if(userInfo==null){
                return null;
            }
            userInfo.setLoginTime(DateUtil.GetDateNow());
            String password=userInfo.getPassword();

            this.setSession("userInfo", userInfo);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    userInfo, //用户实体
                    password, //密码
                    getName()  //realm name
            );
            return authenticationInfo;
        }
        else{
            //log.error(responseResult.getMessage());
            throw new AuthenticationException(responseResult.getMessage());
        }

    }

    /**
     * 根据userid获取roleCode集合
     * @param userId
     * @return
     */
    private Set<String> getRoleCodesByUserId(Long userId) throws Exception{
        Set<String> result=new HashSet();
        SysRoleParam sysRoleParam =new SysRoleParam();
        sysRoleParam.setUserId(userId);

        //ResponseResult<SysRole> sysRoleResponseResult = sysRoleServiceFeign.getSysRoleByUserId(sysRoleParam);
        ResponseResult<SysRole> sysRoleResponseResult = null;

        if(sysRoleResponseResult.getStatus().getValue().equals(Status.SUCCESS.getValue())){
            List<SysRole> sysRoleList= sysRoleResponseResult.getDataList();
            if(!ListUtil.isEmpty(sysRoleList)){
                for(SysRole sysRole:sysRoleList){
                    result.add(sysRole.getRoleCode());
                }
            }
        }
        else {
            //log.error("getRoleCodesByUserId.error");
            return null;
        }
        return result;
    }
    /**
     * 根据userid获取permission集合
     * @param userId
     * @return
     */
    private Set<String> getPermissionByUserId(Long userId) throws Exception{
        Set<String> result=new HashSet();
        RolePermissionParam rolePermissionParam=new RolePermissionParam();
        rolePermissionParam.setUserId(userId);
        //ResponseResult<RolePermission> sysRoleResponseResult= sysResourceServiceFeign.selectShiroUrlPermissionByUserId(rolePermissionParam);
        ResponseResult<RolePermission> sysRoleResponseResult = null;
        if(sysRoleResponseResult.getStatus().getValue().equals(Status.SUCCESS.getValue())){
            List<RolePermission> rolePermissionList= sysRoleResponseResult.getDataList();
            if(!ListUtil.isEmpty(rolePermissionList)){
                for(RolePermission rolePermission:rolePermissionList){
                    result.add(rolePermission.getPermission());
                }
            }
        }
        else {
            //log.error("getPermissionByUserId.error");
            return null;
        }
        return result;
    }

    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null) {
            Session session = currentUser.getSession();
            if (session != null) {
                session.setAttribute(key, value);
            }
        }

    }

    /**
     * 获取当前登录用户
     * @return
     */
    public static UserInfo getUserInfo(){
        Subject currentSubject = SecurityUtils.getSubject();
        UserInfo userInfo=new UserInfo();
        if(currentSubject!=null){
            Session session=currentSubject.getSession();
            if(session!=null) {
                userInfo = (UserInfo) session.getAttribute("userInfo");
            }

        }
        return userInfo;
    }

}
