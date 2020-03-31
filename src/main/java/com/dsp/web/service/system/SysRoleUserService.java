package com.dsp.web.service.system;

import com.dsp.web.model.system.SysRoleUserParam;
import com.dsp.web.model.system.SysRoleUserVo;
import com.dsp.web.model.system.SysRoleVo;

import java.util.List;

public interface SysRoleUserService {
    boolean updateSysRoleUser(SysRoleUserVo vo);

    boolean insertSysRoleUser(SysRoleUserVo vo);

    List<SysRoleUserVo> querySysRoleUserList(SysRoleUserParam vo);

    boolean deleteSysRoleUserbyID(String id);
}
