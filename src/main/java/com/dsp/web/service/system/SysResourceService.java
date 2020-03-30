package com.dsp.web.service.system;

import com.dsp.web.model.system.SysResourceParam;
import com.dsp.web.model.system.SysResourceVo;
import com.dsp.web.model.system.SysUserParam;
import com.dsp.web.model.system.SysUserVo;
import com.dsp.web.model.vo.ResponseResult;

import java.util.List;

public interface SysResourceService {

    ResponseResult<Object> querySysResourceByPrimaryKey(String id);

    ResponseResult updateSysResource(SysResourceVo obj);

    ResponseResult insertSysResource(SysResourceVo obj);

    ResponseResult deleteResourceByID(String orgid);

    List<SysResourceVo> querySysResourceList(SysResourceParam obj);
}
