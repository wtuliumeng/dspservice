package com.dsp.web.controller.system;

import java.util.List;
import com.dsp.web.common.enums.Status;
import com.dsp.web.model.system.SysMenuParam;
import com.dsp.web.model.system.SysMenuVo;
import com.dsp.web.model.system.TreeNodeVo;
import com.dsp.web.model.vo.ResponseResult;
import com.dsp.web.service.system.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 *
 * 此接口为外部提供调用,通过注册中心获取相关业务接口标识，通过[feign]rest形式调用服务方接口
 */

@RestController
@RequestMapping(value = "sysMenu-api")
public class SysMenuController {


    @Autowired
    private SysMenuService sysMenuService;


    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/querySysMenuByPrimaryKey", method = RequestMethod.POST)
    public ResponseResult<SysMenuVo> querySysMenuByPrimaryKey(@RequestParam("ID") Long ID) throws Exception {
        ResponseResult<SysMenuVo> result = new ResponseResult<>();
        try {
            if(ID != null) {
                result = sysMenuService.querySysMenuByPrimaryKey(ID);
            } else {
                result.setStatus(Status.FAILED);
                result.setMessage("执行异常,参数不完整");
            }
            return result;
        } catch (Exception ex) {
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    /**
     * 取得List业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/querySysMenuList", method = RequestMethod.POST)
    public ResponseResult<List<TreeNodeVo>> querySysMenuList(@RequestBody SysMenuParam sysMenuParam) throws Exception {
        ResponseResult<List<SysMenuVo>> result = new ResponseResult<>();
        ResponseResult<List<TreeNodeVo>> resulttree = new ResponseResult<>();
        try {
            List<SysMenuVo> sysMenuVos = sysMenuService.querySysMenuList(sysMenuParam);
            resulttree.setData(SysMenuVo.ToTreeModel(sysMenuVos));
            resulttree.setStatus(Status.SUCCESS);
            resulttree.setMessage("查询成功");
            return resulttree;
        } catch (Exception ex) {
            resulttree.setStatus(Status.FAILED);
            resulttree.setMessage("执行异常,请重试");
            return resulttree;
        }
    }




    /**
     * 插入一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseResult<Object> insertSysMenu(@RequestBody SysMenuVo obj) throws Exception {
        ResponseResult<Object> result = new ResponseResult();
        try {
            if(obj != null && obj.getId() > 0)
            {
                sysMenuService.updateSysMenu(obj);
                result.setStatus(Status.SUCCESS);
                result.setMessage("更新成功");
            } else {
                sysMenuService.insertSysMenu(obj);
                result.setStatus(Status.SUCCESS);
                result.setMessage("新增成功");
            }
            return result;
        } catch (Exception ex) {
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 修改一个业务对象
     *
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "/updateSysMenu", method = RequestMethod.POST)
//    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
//    public ResponseResult updateSysMenu(@RequestBody SysMenuVo obj) throws Exception {
//        ResponseResult result = new ResponseResult();
//        try {
//            return feiservice.updateSysMenu(obj);
//        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
//            result.setStatus(Status.FAILED);
//            result.setMessage("执行异常,请重试");
//            return result;
//        }
//    }
    /**
     * 删除一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteSysMenu", method = RequestMethod.POST)
    public ResponseResult<Object> deleteSysMenu(@RequestParam("ids") String ids) throws Exception {
        ResponseResult<Object> result = new ResponseResult();
        try {

            if(ids != null && !ids.equals(""))
            {
                sysMenuService.deleteSysMenu(ids);
                result.setStatus(Status.SUCCESS);
                result.setMessage("删除成功");
            }
            else
            {
                result.setStatus(Status.FAILED);
                result.setMessage("删除失败");
            }
            return result;
        } catch (Exception ex) {
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
}