package com.dsp.web.service.system;

import com.dsp.web.model.shiro.LoginInfoVo;

public interface LoginService {

    LoginInfoVo getLoginInfoByUserId(String userId);

}
