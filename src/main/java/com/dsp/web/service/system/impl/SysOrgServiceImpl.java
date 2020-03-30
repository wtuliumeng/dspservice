package com.dsp.web.service.system.impl;

import com.dsp.web.model.system.SysOrgParam;
import com.dsp.web.model.system.SysOrgVo;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.system.SysOrgService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysOrgServiceImpl implements SysOrgService {
    @Override
    public ResponseResult<Object> updateSysOrg(SysOrgVo vo) {
        return null;
    }

    @Override
    public ResponseResult<Object> insertSysOrg(SysOrgVo vo) {
        return null;
    }

    @Override
    public List<SysOrgVo> querySysOrgList(SysOrgParam vo) {
        List<SysOrgVo> sysOrgVoList = new ArrayList<>();
        SysOrgVo sysOrgVo = new SysOrgVo();
        sysOrgVo.setId(1L);
        sysOrgVo.setOrgName("深农商全行");
        sysOrgVo.setParentId("0");
        sysOrgVo.setOrgLevel("1");
        sysOrgVo.setOrgType("org");
        sysOrgVo.setValidateState("1");
        sysOrgVoList.add(sysOrgVo);

        SysOrgVo sysOrgVo1 = new SysOrgVo();
        sysOrgVo1.setId(2L);
        sysOrgVo1.setOrgName("数据管理部");
        sysOrgVo1.setParentId("1");
        sysOrgVo1.setOrgLevel("2");
        sysOrgVo1.setOrgType("dept");
        sysOrgVo1.setValidateState("1");
        sysOrgVoList.add(sysOrgVo1);

        SysOrgVo sysOrgVo2 = new SysOrgVo();
        sysOrgVo2.setId(3L);
        sysOrgVo2.setOrgName("信息技术部");
        sysOrgVo2.setParentId("1");
        sysOrgVo2.setOrgLevel("2");
        sysOrgVo2.setOrgType("dept");
        sysOrgVo2.setValidateState("1");
        sysOrgVoList.add(sysOrgVo2);

        SysOrgVo sysOrgVo3 = new SysOrgVo();
        sysOrgVo3.setId(4L);
        sysOrgVo3.setOrgName("数据管理中心");
        sysOrgVo3.setParentId("2");
        sysOrgVo3.setOrgLevel("3");
        sysOrgVo3.setOrgType("center");
        sysOrgVo3.setValidateState("1");
        sysOrgVoList.add(sysOrgVo3);

        return sysOrgVoList;
    }

    @Override
    public ResponseResult<Object> querySysOrgByPrimaryKey(String orgid) {
        return null;
    }

    @Override
    public ResponseResult deleteOrgByID(String orgid) {
        return null;
    }
}
