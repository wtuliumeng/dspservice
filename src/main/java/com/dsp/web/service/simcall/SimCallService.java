package com.dsp.web.service.simcall;

import com.dsp.web.model.simcall.UserSimCertifyVo;

public interface SimCallService {

    UserSimCertifyVo getSimCertifyInfo(String userName, String password, String ipAddr);

}
