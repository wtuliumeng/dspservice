package com.dsp.web.service.monitorCenter;

import com.dsp.web.model.monitorCenter.QuerySearch;

import java.util.Date;
import java.util.List;

/**
 * Created by zhouyang on 2020/3/26.
 */
//创建接口
public interface DataSearchService {
    List<QuerySearch> getdataSearchList(String querynumber, String tasknumber, String callsystem, String status, Date rundate, int currentPage, int pageSize);

    int getdataSearchCount(String querynumber, String tasknumber, String callsystem, String status, Date rundate);
}
