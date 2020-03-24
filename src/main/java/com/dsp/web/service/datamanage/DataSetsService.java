package com.dsp.web.service.datamanage;

import com.dsp.web.model.datamanage.DataSetsParam;
import com.dsp.web.model.datamanage.DataSets;

import java.util.List;

public interface DataSetsService {
    List<DataSets> getDataSetsList(DataSetsParam dataSetsParam);

    Long getDataSetsCount(DataSetsParam dataSetsParam);

    boolean add(DataSets dataSetsVo);

    boolean delete(String id);

    boolean deleteBatch(List<String> ids);

    boolean update(DataSets dataSetsVo);
}
