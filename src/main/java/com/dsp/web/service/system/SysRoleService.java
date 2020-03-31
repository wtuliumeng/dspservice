package com.dsp.web.service.system;

import com.dsp.web.model.shiro.SysRole;
import com.dsp.web.model.system.SysRoleParam;
import com.dsp.web.model.system.SysRoleVo;

import java.util.List;

public interface SysRoleService {
    boolean updateSysRole(SysRoleVo vo);

    boolean insertSysRole(SysRoleVo vo);

    List<SysRole> querySysRoleByPrimaryKey(String id);

    boolean deleteSysRolebyID(String id);

    List<SysRoleVo> querySysRoleList(SysRoleParam vo);
}
