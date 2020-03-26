package com.dsp.web.service.monitorCenter;

import com.dsp.web.model.monitorCenter.DataSearch;

import java.util.List;
import java.util.Date;

/**
 * Created by zhouyang on 2020/3/26.
 */
public interface QueryDataSearchService {
    List<DataSearch> getquerySearchList(String name, String sqlname, String switcsystem,String resource,Date rundate, int currentPage, int pageSize);

    int getquerySearchCount(String name, String sqlname, String switcsystem,String resource,Date rundate);
}
