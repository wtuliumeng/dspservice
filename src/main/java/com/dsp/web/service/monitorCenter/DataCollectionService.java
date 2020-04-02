package com.dsp.web.service.monitorCenter;

import com.dsp.web.model.mon.DataCollection;

import java.util.List;

public interface DataCollectionService {

    List<DataCollection> getSearchList(String sqlId, String name, String resource, int currentPage, int pageSize);

    int getSearchCount(String sqlId, String name, String resource);
}
