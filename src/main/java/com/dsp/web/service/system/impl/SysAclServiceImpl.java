package com.dsp.web.service.system.impl;

import com.dsp.web.model.system.SysAclParam;
import com.dsp.web.model.system.SysAclVo;
import com.dsp.web.service.system.SysAclService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SysAclServiceImpl implements SysAclService {
    /* 造假数据 */
    private List<SysAclVo> sysAclVos = new ArrayList<>();

    public List<SysAclVo> querySysAclList(SysAclParam obj) {
        List<SysAclVo> sysAclVoList = new ArrayList<>();
        if(this.sysAclVos.size() <= 0){
            for(long i = 0;i < 3;i++){
                SysAclVo sysAclVo =  new SysAclVo();
                sysAclVo.setId(i);
                sysAclVo.setRoleId(i);
                sysAclVo.setResoureId(i);
                this.sysAclVos.add(sysAclVo);
            }
        }

        for(int i = 0 ; i < this.sysAclVos.size() ; i++){
            if (this.sysAclVos.get(i).getRoleId().longValue() == obj.getRoleId().longValue()) {
                sysAclVoList.add(this.sysAclVos.get(i));
            }
        }
        return sysAclVoList;
    }

    public void insertSysAcl(SysAclVo vo) {
        //先删再加
        for(int i = 0 ; i < this.sysAclVos.size() ; i++){
            if(this.sysAclVos.get(i).getRoleId().longValue() == vo.getRoleId().longValue()){
                this.sysAclVos.remove(i);
            }
        }

        for(int i = 0 ; i < vo.getResourceids().length; i++){
            SysAclVo sysAclVo = new SysAclVo();
            sysAclVo.setRoleId(vo.getRoleId());
            String resourceid = vo.getResourceids()[i];
            sysAclVo.setResoureId(Long.valueOf(resourceid));
            this.sysAclVos.add(sysAclVo);
        }
    }
}
