package com.dsp.web.service.simcall.impl;

import com.dsp.web.model.simcall.SimCallTask;
import com.dsp.web.model.simcall.SimCallTaskVo;
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
    //TODO
    //假数据
    @Override
    public UserSimCertifyVo getSimCertifyInfo(String userName, String password, String ipAddr){
        UserSimCertifyVo userSimCertifyVo = new UserSimCertifyVo();
        userSimCertifyVo.setUserName("王某人模拟认证"+userName);
        userSimCertifyVo.setToken("20200320xxx"+password);
        userSimCertifyVo.setAuthTime("2020-03-20"+ipAddr);
        return userSimCertifyVo;
    }

    @Override
    public SimCallTaskVo getAsyncTask(SimCallTask simCallTask){
        SimCallTaskVo result = new SimCallTaskVo();
        result.setSqlId("异步sqlId"+simCallTask.getSqlId());
        result.setState("异步用户名,ip:"+simCallTask.getUserName()+","+simCallTask.getIp());
        result.setRetCode("异步token，提数参数："+simCallTask.getToken()+","+simCallTask.getParams());
        result.setDescription("异步数据总量参数，跑批参数:"+simCallTask.getTotalDataParam()+","+simCallTask.getBatchParam());
        return result;
    }

    @Override
    public SimCallTaskVo getSyncTask(SimCallTask simCallTask){
        SimCallTaskVo result = new SimCallTaskVo();
        result.setSqlId("实时sqlId"+simCallTask.getSqlId());
        result.setState("实时用户名,ip:"+simCallTask.getUserName()+","+simCallTask.getIp());
        result.setRetCode("实时跑批参数，提数参数："+simCallTask.getBatchParam()+","+simCallTask.getParams());
        result.setDescription("实时页码，每页个数:"+simCallTask.getPageNum()+","+simCallTask.getCountPage());
        return result;
    }
}
