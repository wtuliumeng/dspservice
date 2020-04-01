package com.dsp.web.service.monitorCenter.impl;


import com.dsp.web.model.mon.RealCall;
import com.dsp.web.service.monitorCenter.RealCallService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
/**
 * Created by zhouyang on 2020/3/26.
 */
@Service
public class RealCallServiceImpl implements RealCallService {

    @Override
    public List<RealCall> getdataSearchList(String querynumber, String tasknumber, String callsystem, String status, Date rundate, int currentPage, int pageSize) {
        List<RealCall> querySearchList = new ArrayList<>();

        /* 造假数据 */
        //假设造假数据总共16条
        //分页
        int start = (currentPage - 1) * pageSize + 1;
        for (int i = 0; i < pageSize; i++) {
            if ((start + i) > 16)
                break;
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String time=sdf.format(date);
            RealCall querySearch = new RealCall();
            querySearch.setQuerynumber("" + (start + i));//查询编号
            querySearch.setTasknumber("" + (start + i));//任务编号
            querySearch.setCallsystem("dsp"+(start+i));//调用方系统
            querySearch.setCalldate(time);//调用日期
            querySearch.setCallparam("" + (start + i));//调用参数
            querySearch.setServicename("" + (start + i));//﻿服务名
            querySearch.setRequestdate(new Date());//请求时间
            querySearch.setReturndate(new Date());//返回时间
            querySearch.setResponcode("" + (start + i));//﻿响应代码
            querySearch.setState("" + (start + i));//﻿任务状态
            querySearch.setDescr("" + (start + i));//描述
            querySearchList.add(querySearch);
        }
        return querySearchList;
    }

    @Override
    public int getdataSearchCount(String querynumber, String tasknumber, String callsystem, String resource, Date rundate) {
        return 20;
    }
}
