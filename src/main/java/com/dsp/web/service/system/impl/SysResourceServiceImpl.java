package com.dsp.web.service.system.impl;

import com.dsp.web.model.system.SysResourceParam;
import com.dsp.web.model.system.SysResourceVo;
import com.dsp.web.model.system.SysUserParam;
import com.dsp.web.model.system.SysUserVo;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.system.SysResourceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysResourceServiceImpl implements SysResourceService {


    private List<SysResourceVo> sysResourceVo = new ArrayList<>();


    @Override
    public ResponseResult<Object> querySysResourceByPrimaryKey(String id) {
        return null;
    }

    @Override
    public ResponseResult updateSysResource(SysResourceVo obj) {
        return null;
    }

    @Override
    public ResponseResult insertSysResource(SysResourceVo obj) {
        return null;
    }

    @Override
    public ResponseResult deleteResourceByID(String orgid) {
        return null;
    }

    @Override
    public List<SysResourceVo> querySysResourceList(SysResourceParam obj) {
        if(this.sysResourceVo.size() <= 0){
            for(long i = 0;i < 3;i++){
                SysResourceVo sysResourceVo = new SysResourceVo();
                sysResourceVo.setId(i);
                sysResourceVo.setResoureName("某资源" + Long.toString(i));
                sysResourceVo.setResoureType(Long.toString(i));
                sysResourceVo.setResoureUrl("api/sysResourceServiceImpl/querySysResourceList");
                sysResourceVo.setPermission("sys");
                sysResourceVo.setParentId(Long.toString((i+1)));
                sysResourceVo.setParentIds(Long.toString((i+2)));
                sysResourceVo.setAppId(i+10086);
                sysResourceVo.setValidateState("1");
                sysResourceVo.setVersion(i);
                this.sysResourceVo.add(sysResourceVo);
            }
        }
        return this.sysResourceVo;
    }
}
