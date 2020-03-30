package com.dsp.web.service.system;

import com.dsp.web.model.system.SysOrgParam;
import com.dsp.web.model.system.SysOrgVo;
import com.dsp.web.model.vo.ResponseResult;

import java.util.List;

public interface SysOrgService {
    ResponseResult<Object> updateSysOrg(SysOrgVo vo);

    ResponseResult<Object> insertSysOrg(SysOrgVo vo);

    List<SysOrgVo> querySysOrgList(SysOrgParam vo);

    ResponseResult<Object> querySysOrgByPrimaryKey(String orgid);

    ResponseResult deleteOrgByID(String orgid);
}
