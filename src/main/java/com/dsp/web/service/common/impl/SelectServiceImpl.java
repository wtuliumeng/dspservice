package com.dsp.web.service.common.impl;

import com.dsp.web.model.vo.SelectModelVo;
import com.dsp.web.service.common.SelectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelectServiceImpl implements SelectService {

    @Override
    public List<SelectModelVo> getSelectList(String type) {
        List<SelectModelVo> modelVoList = new ArrayList<>();
        /*造假数据*/
        if("1".equals(type)){
            //数据集类型
            SelectModelVo vo1 = new SelectModelVo("对公客户类","1","1");
            SelectModelVo vo2 = new SelectModelVo("对私客户类","2","1");
            SelectModelVo vo3 = new SelectModelVo("贷款类","3","1");
            SelectModelVo vo4 = new SelectModelVo("营销类","4","1");
            modelVoList.add(vo1);
            modelVoList.add(vo2);
            modelVoList.add(vo3);
            modelVoList.add(vo4);
        }
        else if("2".equals(type)){
            SelectModelVo vo1 = new SelectModelVo("李四","1","2");
            SelectModelVo vo2 = new SelectModelVo("王五","2","2");
            SelectModelVo vo3 = new SelectModelVo("赵六","3","2");
            SelectModelVo vo4 = new SelectModelVo("法 外 狂 徒","4","2");
            modelVoList.add(vo1);
            modelVoList.add(vo2);
            modelVoList.add(vo3);
            modelVoList.add(vo4);
        }
        return modelVoList;
    }

    @Override
    public SelectModelVo getLabel(String type, String value) {
        SelectModelVo modelVo = new SelectModelVo();
        if("1".equals(type)){
            if("1".equals(value)){
                modelVo.setLabel("对公客户类");
            }else if("2".equals(value)){
                modelVo.setLabel("对私客户类");
            }else if("3".equals(value)){
                modelVo.setLabel("贷款类");
            }else if("4".equals(value)){
                modelVo.setLabel("营销类");
            }
        }
        return modelVo;
    }
}
