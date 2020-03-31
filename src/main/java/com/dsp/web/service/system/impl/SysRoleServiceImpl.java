package com.dsp.web.service.system.impl;

import com.dsp.web.model.shiro.SysRole;
import com.dsp.web.model.system.SysRoleParam;
import com.dsp.web.model.system.SysRoleVo;
import com.dsp.web.service.system.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    private List<SysRoleVo> sysRoleVos = new ArrayList<>();

    @Override
    public boolean updateSysRole(SysRoleVo vo) {
        for(int i = 0; i< this.sysRoleVos.size();i++){
            if(this.sysRoleVos.get(i).getId() == vo.getId()){
                this.sysRoleVos.remove(i);
                this.sysRoleVos.add(0,vo);
                break;
            }
        }
        return false;
    }

    @Override
    public boolean insertSysRole(SysRoleVo vo) {
        vo.setId((long)this.sysRoleVos.size());
        this.sysRoleVos.add(0,vo);
        return false;
    }

    @Override
    public List<SysRole> querySysRoleByPrimaryKey(String id) {
        return null;
    }

    @Override
    public boolean deleteSysRolebyID(String id) {
        for(int i = 0;i< this.sysRoleVos.size();i++){
            if(this.sysRoleVos.get(i).getId().toString().equals(id)){
                this.sysRoleVos.remove(i);
                break;
            }
        }
        return true;
    }

    @Override
    public List<SysRoleVo> querySysRoleList(SysRoleParam vo) {
        if(this.sysRoleVos.size() <= 0){
            SysRoleVo vo1 = new SysRoleVo();
            vo1.setId(1L);
            vo1.setRoleCode("admin");
            vo1.setRoleName("管理员");
            vo1.setRoleType("0");
            this.sysRoleVos.add(vo1);

            SysRoleVo vo2 = new SysRoleVo();
            vo2.setId(2L);
            vo2.setRoleCode("aicc");
            vo2.setRoleName("电话银行");
            vo2.setRoleType("2");
            this.sysRoleVos.add(vo2);

            SysRoleVo vo3 = new SysRoleVo();
            vo3.setId(3L);
            vo3.setRoleCode("qdkf");
            vo3.setRoleName("渠道开发");
            vo3.setRoleType("2");
            this.sysRoleVos.add(vo3);

            SysRoleVo vo4 = new SysRoleVo();
            vo4.setId(4L);
            vo4.setRoleCode("fas");
            vo4.setRoleName("流水分析");
            vo4.setRoleType("2");
            this.sysRoleVos.add(vo4);
        }
        return this.sysRoleVos;
    }
}
