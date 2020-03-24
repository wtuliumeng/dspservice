package com.dsp.web.service.common;

import com.dsp.web.model.vo.SelectModelVo;

import java.util.List;

public interface SelectService {
    List<SelectModelVo> getSelectList(String type);

    SelectModelVo getLabel(String type, String value);
}
