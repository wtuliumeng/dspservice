package com.dsp.web.service.system.impl;

import com.dsp.web.common.enums.Status;
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
        /*假数据*/
        SysResourceVo sysResourceVo = new SysResourceVo();
        ResponseResult<Object> result = new ResponseResult<>();
        long i = 1;
        sysResourceVo.setId(i);
        sysResourceVo.setResoureName("主键查询" + Long.toString(i));
        sysResourceVo.setResoureType(Long.toString(i));
        sysResourceVo.setResoureUrl("api/sysResourceServiceImpl/querySysResourceByPrimaryKey");
        sysResourceVo.setPermission("sys");
        sysResourceVo.setParentId(Long.toString((i+1)));
        sysResourceVo.setAppId(i+10086);
        sysResourceVo.setValidateState("1");
        sysResourceVo.setVersion(i);

        result.setData(sysResourceVo);
        return result;
    }

    @Override
    public ResponseResult updateSysResource(SysResourceVo obj) {
        boolean flag = true;
        //更新资源函数 TODO
        //flag = updateDB();
        ResponseResult result = new ResponseResult();

        if(flag) {
            result.setStatus(Status.SUCCESS);
            result.setMessage("更新成功！");
        }else{
            result.setStatus(Status.FAILED);
            result.setMessage("更新失败！");
        }
        return result;
    }

    @Override
    public ResponseResult insertSysResource(SysResourceVo obj) {
        boolean flag = true;
        //更新资源函数 TODO
        //flag = insertDB();
        ResponseResult result = new ResponseResult();

        if(flag) {
            result.setStatus(Status.SUCCESS);
            result.setMessage("新增成功！");
        }else{
            result.setStatus(Status.FAILED);
            result.setMessage("新增失败！");
        }
        return result;
    }

    @Override
    public ResponseResult deleteResourceByID(String orgid) {
        boolean flag = true;
        //更新资源函数 TODO
        //flag = deleteDB();
        ResponseResult result = new ResponseResult();

        if(flag) {
            result.setStatus(Status.SUCCESS);
            result.setMessage("删除成功！");
        }else{
            result.setStatus(Status.FAILED);
            result.setMessage("删除失败！");
        }
        return result;
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
                //sysResourceVo.setParentId(Long.toString((i+1)));
                //sysResourceVo.setParentId("1");
                //sysResourceVo.setParentIds(Long.toString((i+1)));
                sysResourceVo.setAppId(i+10086);
                sysResourceVo.setValidateState("1");
                sysResourceVo.setVersion(i);
                this.sysResourceVo.add(sysResourceVo);
            }
        }
        return this.sysResourceVo;
    }
}
