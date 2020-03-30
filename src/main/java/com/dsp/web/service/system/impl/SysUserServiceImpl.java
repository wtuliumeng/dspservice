package com.dsp.web.service.system.impl;

import com.dsp.web.model.system.SysUserParam;
import com.dsp.web.model.system.SysUserVo;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.system.SysUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {


    private List<SysUserVo> sysUserVos = new ArrayList<>();

    @Override
    public Long updateSysUser(SysUserVo vo) {
        for(int i = 0 ; i < this.sysUserVos.size() ; i++){
            if(this.sysUserVos.get(i).getId() == vo.getId()){
                this.sysUserVos.remove(i);
                this.sysUserVos.add(0,vo);
                break;
            }
        }
        return 0L;
    }

    @Override
    public Long insertSysUser(SysUserVo vo) {
        vo.setId((long)this.sysUserVos.size() + 1);
        this.sysUserVos.add(0,vo);
        return vo.getId();
    }

    @Override
    public ResponseResult<SysUserVo> querySysUserByPrimaryKey(String id) {
        return null;
    }

    @Override
    public List<SysUserVo> querySysUserList(SysUserParam vo) {
        if(this.sysUserVos.size() <= 0){
            for(long i = 0;i < 3;i++){
                SysUserVo sysUserVo =  new SysUserVo();
                sysUserVo.setId(i);
                sysUserVo.setUserName("智能外呼");
                sysUserVo.setLoginName("aicc");
                sysUserVo.setOrgname("渠道");
                sysUserVo.setCharge("董先龙");
                sysUserVo.setMobile("13112345678");
                sysUserVo.setValidateState("1");
                this.sysUserVos.add(sysUserVo);
            }
        }
        return this.sysUserVos;
    }

    @Override
    public void delSysUserByUserId(String ids) {
        String[] idList = ids.split(",");
        for(String id : idList){
            for(int i = 0;i < this.sysUserVos.size();i++){
                if(this.sysUserVos.get(i).getId().toString().equals(id)){
                    this.sysUserVos.remove(i);
                    break;
                }
            }
        }

    }

    @Override
    public ResponseResult<Object> checkOldPassWord(String loginName, String oldPassword, String newPassword) {
        return null;
    }
}
