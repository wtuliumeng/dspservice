package com.dsp.web.service.system;

import com.dsp.web.model.system.SysMenuParam;
import com.dsp.web.model.system.SysMenuVo;
import com.dsp.web.model.system.TreeNodeVo;
import com.dsp.web.model.vo.ResponseResult;

import java.util.List;

public interface SysMenuService {
    ResponseResult<SysMenuVo> querySysMenuByPrimaryKey(Long ID);

    List<SysMenuVo> querySysMenuList(SysMenuParam sysMenuParam);

    Long updateSysMenu(SysMenuVo vo);

    Long insertSysMenu(SysMenuVo vo);

    void deleteSysMenu(String ids);
}
