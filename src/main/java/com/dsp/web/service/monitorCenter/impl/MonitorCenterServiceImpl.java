package com.dsp.web.service.monitorCenter.impl;

import com.dsp.web.model.monitorCenter.OnSearch;
import com.dsp.web.service.monitorCenter.MonitorCenterService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhouyang on 2020/3/24.
 */
@Service
public class MonitorCenterServiceImpl implements MonitorCenterService {
    @Override
    public List<OnSearch> getSearchList(String sqlId, String name, String status, int currentPage, int pageSize) {
        List<OnSearch> onSearchList = new ArrayList<>();

        /* 造假数据 */
        //假设造假数据总共16条
        //分页
        int start = (currentPage - 1) * pageSize + 1;
        for (int i = 0; i < pageSize; i++) {
            if ((start + i) > 16)
                break;
            OnSearch onSearch = new OnSearch();
            onSearch.setName("" + (start + i));
            onSearch.setSqlId("" + (start + i));
            onSearch.setCreatetime("" + (start + i));
            onSearch.setEndtime("" + (start + i));
            onSearch.setDescript("" + (start + i));
            onSearch.setState("" + (start + i));
            onSearchList.add(onSearch);
        }
        return onSearchList;
    }
    @Override
    public int getSearchCount(String sqlId, String name, String status) {
        /*造假数据*/
        return 16;
    }
}

