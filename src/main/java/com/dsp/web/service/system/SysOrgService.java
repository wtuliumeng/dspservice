package com.dsp.web.service.system;

import com.dsp.web.model.system.SysOrgParam;
import com.dsp.web.model.system.SysOrgVo;
import com.dsp.web.model.vo.ResponseResult;

import java.util.List;

public interface SysOrgService {
    boolean updateSysOrg(SysOrgVo vo);

    boolean insertSysOrg(SysOrgVo vo);

    List<SysOrgVo> querySysOrgList(SysOrgParam vo);

    SysOrgVo querySysOrgByPrimaryKey(String orgid);

    boolean deleteOrgByID(String orgid);
}
