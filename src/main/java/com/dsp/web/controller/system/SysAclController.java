package com.dsp.web.controller.system;
import java.util.List;


import com.dsp.web.common.enums.Status;
import com.dsp.web.model.system.SysAclParam;
import com.dsp.web.model.system.SysAclVo;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.system.SysAclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * 此接口为外部提供调用,通过注册中心获取相关业务接口标识，通过[feign]rest形式调用服务方接口
 */

@RestController
@RequestMapping(value = "/sysAcl-api")
public class SysAclController {


    @Autowired
    private SysAclService sysAclService;


    /**
     * 取得List业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getSysAclList", method = RequestMethod.POST)
    public ResponseResult<Object> querySysAclList(@RequestBody SysAclParam obj) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            List<SysAclVo> sysAclVos = sysAclService.querySysAclList(obj);;
            result.setData(sysAclVos);
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    /**
     * 插入一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertSysAcl", method = RequestMethod.POST)
    public ResponseResult insertSysAcl(@RequestBody SysAclVo obj) throws Exception {
        ResponseResult result = new ResponseResult();
        System.out.println("test1");
        try {
            System.out.println("test2");
            sysAclService.insertSysAcl(obj);
            System.out.println("test3");
            result.setStatus(Status.SUCCESS);
            return result;
        } catch (Exception ex) {
            System.out.println("test4");
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

}