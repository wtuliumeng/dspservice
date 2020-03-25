package com.dsp.web.service.datamanage;

import com.dsp.web.model.datamanage.DataRetrievalParam;
import com.dsp.web.model.datamanage.DataRetrievalVo;

public interface DataRetrievalService {
    DataRetrievalVo getTableList(DataRetrievalParam param);
}
