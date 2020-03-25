package com.dsp.web.service.simcall;

import com.dsp.web.model.simcall.SimCallTask;
import com.dsp.web.model.simcall.SimCallTaskVo;
import com.dsp.web.model.simcall.UserSimCertifyVo;

public interface SimCallService {
    //用户模拟认证
    UserSimCertifyVo getSimCertifyInfo(String userName, String password, String ipAddr);
    //获取异步任务信息
    SimCallTaskVo getAsyncTask(SimCallTask simCallTask);
    //获取实时任务信息
    SimCallTaskVo getSyncTask(SimCallTask simCallTask);
}
