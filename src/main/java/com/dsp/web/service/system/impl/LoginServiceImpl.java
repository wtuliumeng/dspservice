package com.dsp.web.service.system.impl;

import com.dsp.web.model.shiro.LoginInfoVo;
import com.dsp.web.model.shiro.RolePermissionVo;
import com.dsp.web.model.shiro.SysMenuVo;
import com.dsp.web.model.shiro.SysRoleVo;
import com.dsp.web.service.system.LoginService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public LoginInfoVo getLoginInfoByUserId(String userId) {
        /*造假数据*/
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

        LoginInfoVo loginInfoVo = new LoginInfoVo();
        loginInfoVo.setRolePermissionVoList(rolePermissionVoList);
        loginInfoVo.setSysRoleVoList(sysRoleVoList);
        loginInfoVo.setSysMenuVoList(sysMenuVoList);
        return loginInfoVo;
    }
}
