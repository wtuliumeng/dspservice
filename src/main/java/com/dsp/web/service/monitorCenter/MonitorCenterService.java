package com.dsp.web.service.monitorCenter;

import com.dsp.web.model.monitorCenter.OnSearch;

import java.util.List;

public interface MonitorCenterService {

    List<OnSearch> getSearchList(String sqlId, String name, String status, int currentPage, int pageSize);

    int getSearchCount(String sqlId, String name, String status);
}
