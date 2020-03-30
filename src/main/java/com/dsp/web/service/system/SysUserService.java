package com.dsp.web.service.system;

import com.dsp.web.model.system.SysUserParam;
import com.dsp.web.model.system.SysUserVo;
import com.dsp.web.model.vo.ResponseResult;

import java.util.List;

public interface SysUserService {
    Long updateSysUser(SysUserVo vo);

    Long insertSysUser(SysUserVo vo);

    ResponseResult<SysUserVo> querySysUserByPrimaryKey(String id);

    List<SysUserVo> querySysUserList(SysUserParam vo);

    void delSysUserByUserId(String ids);

    ResponseResult<Object> checkOldPassWord(String loginName, String oldPassword, String newPassword);
}
