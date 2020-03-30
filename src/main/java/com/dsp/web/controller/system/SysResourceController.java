package com.dsp.web.controller.system;
import java.util.ArrayList;
import java.util.List;

import com.dsp.web.model.system.SysResourceParam;
import com.dsp.web.model.system.SysResourceVo;
import com.dsp.web.model.system.TreeNodeVo;

import com.dsp.web.service.system.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dsp.web.common.enums.Status;
import com.dsp.web.model.vo.ResponseResult;
import org.springframework.util.StringUtils;

/**
 *
 * 此接口为外部提供调用,通过注册中心获取相关业务接口标识，通过[feign]rest形式调用服务方接口
 */

@RestController
@RequestMapping(value = "sysResource_api")

//@Api(tags = {"资源管理接口-hanxiaoyan"})
public class SysResourceController {


    @Autowired
    private SysResourceService feiservice;


    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/querySysResourceByPrimaryKey", method = RequestMethod.POST)
    //@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> querySysResourceByPrimaryKey(@RequestParam("ID") String ID) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = feiservice.querySysResourceByPrimaryKey(ID);
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功！");
            return result;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
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
    @RequestMapping(value = "/getSysResourceList", method = RequestMethod.POST)
    //@ApiOperation(value = "查询返回List对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<List<TreeNodeVo>> querySysResourceList(@RequestBody SysResourceParam obj) throws Exception {
        List<SysResourceVo> result = new ArrayList<>();
        ResponseResult<List<TreeNodeVo>> resulttree = new ResponseResult<>();
        try {
            result= feiservice.querySysResourceList(obj);
            resulttree.setData(SysResourceVo.ToTreeModel(result));
            resulttree.setStatus(Status.SUCCESS);
            resulttree.setMessage("执行成功！");
            return resulttree;
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            resulttree.setStatus(Status.FAILED);
            resulttree.setMessage("执行异常,请重试");
            return resulttree;

        }
    }


    /**
     * 根据对象查询信息返回单个实体
     *
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "/queryLike", method = RequestMethod.POST)
//    //@ApiOperation(value = "查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
//    public ResponseResult<Object> queryLike(@RequestBody SysResourceVo obj) throws Exception {
//        ResponseResult<Object> result = new ResponseResult<>();
//        try {
//            return feiservice.queryLikeSysResource(obj);
//        } catch (Exception ex) {
//            //log.error(ex.getMessage(), ex);
//            result.setStatus(Status.FAILED);
//            result.setMessage("执行异常,请重试");
//            return result;
//
//        }
//    }


    /**
     * 插入一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveSysResource", method = RequestMethod.POST)
    //@ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult insertSysResource(@RequestBody SysResourceVo obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            obj.setValidateState("1");
            obj.setVersion((long)1);
            if(obj!=null&&obj.getId()>0) {
                return feiservice.updateSysResource(obj);
            }
            else {
                return feiservice.insertSysResource(obj);
            }
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
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
//    @RequestMapping(value = "/Web/update/v1", method = RequestMethod.POST)
//    //@ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
//    public ResponseResult updateSysResource(@RequestBody SysResourceVo obj) throws Exception {
//        ResponseResult result = new ResponseResult();
//        try {
//            return feiservice.updateSysResource(obj);
//        } catch (Exception ex) {
//            //log.error(ex.getMessage(), ex);
//            result.setStatus(Status.FAILED);
//            result.setMessage("执行异常,请重试");
//            return result;
//        }
//    }
    //@ApiOperation(value="根据主键id删除资源数据",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/deleteResourceByID",method = RequestMethod.POST)
    public ResponseResult deleteResourceByID(@RequestParam("") String orgid)throws Exception {
        ResponseResult result = new ResponseResult<>();
        try {
            return feiservice.deleteResourceByID(orgid);
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

}