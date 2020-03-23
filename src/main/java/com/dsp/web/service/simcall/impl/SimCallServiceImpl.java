package com.dsp.web.service.simcall.impl;

import com.dsp.web.model.simcall.UserSimCertifyParam;
import com.dsp.web.service.simcall.SimCallService;
import com.dsp.web.model.simcall.UserSimCertifyVo;
import com.dsp.web.model.shiro.LoginInfoVo;
import com.dsp.web.model.shiro.RolePermissionVo;
import com.dsp.web.model.shiro.SysMenuVo;
import com.dsp.web.model.shiro.SysRoleVo;
import com.dsp.web.service.system.LoginService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimCallServiceImpl implements SimCallService {

    @Override
    public UserSimCertifyVo getSimCertifyInfo(String userName, String password, String ipAddr){
        UserSimCertifyVo userSimCertifyVo = new UserSimCertifyVo();
        userSimCertifyVo.setUserName("王某人模拟认证"+userName);
        userSimCertifyVo.setToken("20200320xxx"+password);
        userSimCertifyVo.setAuthTime("2020-03-20"+ipAddr);
        return userSimCertifyVo;
    }
}
