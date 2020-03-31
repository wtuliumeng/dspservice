package com.dsp.web.service.system.impl;

import com.dsp.web.model.system.SysRoleUserParam;
import com.dsp.web.model.system.SysRoleUserVo;
import com.dsp.web.model.system.SysRoleVo;
import com.dsp.web.service.system.SysRoleUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {
    private List<SysRoleUserVo> vos = new ArrayList<>();

    @Override
    public boolean updateSysRoleUser(SysRoleUserVo vo) {
        for(int  i = 0; i < vos.size() ;i++){
            if(vos.get(i).getId() == vo.getId()){
                vos.remove(i);
                vos.add(0,vo);
                break;
            }
        }
        return false;
    }

    @Override
    public boolean insertSysRoleUser(SysRoleUserVo vo) {
        vo.setId(vos.size() + 100L);
        vos.add(0,vo);
        return true;
    }

    @Override
    public List<SysRoleUserVo> querySysRoleUserList(SysRoleUserParam vo) {
        if(vos.size() <= 0){
            SysRoleUserVo vo1 = new SysRoleUserVo();
            vo1.setTargetId(1L);
            vo1.setUserName("管理员");
            vo1.setId(101L);
            vos.add(vo1);
            SysRoleUserVo vo2 = new SysRoleUserVo();
            vo2.setTargetId(2L);
            vo2.setUserName("电话银行");
            vo2.setId(102L);
            vos.add(vo2);
        }
        return vos;
    }

    @Override
    public boolean deleteSysRoleUserbyID(String id) {
        for(int i = 0;i < vos.size();i++){
            if(vos.get(i).getId().toString().equals(id)){
                vos.remove(i);
                break;
            }
        }
        return false;
    }
}
