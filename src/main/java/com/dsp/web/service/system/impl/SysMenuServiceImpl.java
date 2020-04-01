package com.dsp.web.service.system.impl;

import com.dsp.web.model.system.SysMenuParam;
import com.dsp.web.model.system.SysMenuVo;
import com.dsp.web.model.system.TreeNodeVo;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.system.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    /* 造假数据 */
    private List<SysMenuVo> sysMenuVos = new ArrayList<>();

    @Override
    public ResponseResult<SysMenuVo> querySysMenuByPrimaryKey(Long ID) {
        ResponseResult<SysMenuVo> result = new ResponseResult();
        for(int i = 0 ; i < this.sysMenuVos.size() ; i++){
            if(this.sysMenuVos.get(i).getId().longValue() == ID.longValue()){
                result.setData(this.sysMenuVos.get(i));
                break;
            }
        }
        return result;
    }

    @Override
    public List<SysMenuVo> querySysMenuList(SysMenuParam sysMenuParam) {
        if(this.sysMenuVos.size() <= 0){
            for(long i = 0;i < 3;i++){
                SysMenuVo sysMenuVo =  new SysMenuVo();
                sysMenuVo.setId((long)(12345+i));
                sysMenuVo.setMenuName("test" + i);
                sysMenuVo.setResourceId(i);
                this.sysMenuVos.add(sysMenuVo);
            }
        }
        return this.sysMenuVos;
    }

    @Override
    public Long updateSysMenu(SysMenuVo vo) {
        for(int i = 0 ; i < this.sysMenuVos.size() ; i++){
            if(this.sysMenuVos.get(i).getId().longValue() == vo.getId().longValue()){
                this.sysMenuVos.remove(i);
                this.sysMenuVos.add(0,vo);
                break;
            }
        }
        return 0L;
    }

    @Override
    public Long insertSysMenu(SysMenuVo vo) {
        vo.setId((long)this.sysMenuVos.size() + 1);
        this.sysMenuVos.add(0,vo);
        return vo.getId();
    }

    @Override
    public   void deleteSysMenu(String ids) {
        String[] idList = ids.split(",");
        for(String id : idList){
            for(int i = 0;i < this.sysMenuVos.size();i++){
                if(this.sysMenuVos.get(i).getId().toString().equals(id)){
                    this.sysMenuVos.remove(i);
                    break;
                }
            }
        }
    }
}
