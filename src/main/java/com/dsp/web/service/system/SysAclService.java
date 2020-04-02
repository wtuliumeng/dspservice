package com.dsp.web.service.system;

import com.dsp.web.model.system.SysAclParam;
import com.dsp.web.model.system.SysAclVo;

import java.util.List;

public interface SysAclService {
	List<SysAclVo> querySysAclList(SysAclParam obj);

	void insertSysAcl(SysAclVo obj);
}
