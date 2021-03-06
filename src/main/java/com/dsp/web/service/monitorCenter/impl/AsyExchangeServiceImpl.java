package com.dsp.web.service.monitorCenter.impl;

import com.dsp.web.model.mon.AsyExchange;
import com.dsp.web.service.monitorCenter.AsyExchangeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 * Created by zhouyang on 2020/3/26.
 */
@Service
public class AsyExchangeServiceImpl implements AsyExchangeService {
    @Override
    public List<AsyExchange> getquerySearchList(String name, String sqlname, String switcsystem, String resource, Date rundate, int currentPage, int pageSize) {
        List<AsyExchange> dataSearchList = new ArrayList<>();

        /* 造假数据 */
        //假设造假数据总共16条
        //分页
        int start = (currentPage - 1) * pageSize + 1;
        for (int i = 0; i < pageSize; i++) {
            if ((start + i) > 16)
                break;
            AsyExchange dataSearch = new AsyExchange();
            dataSearch.setNumber("" + (start + i));
            dataSearch.setSqlnumber("" + (start + i));
            dataSearch.setSwitchsystem("dsp"+(start+i));
            dataSearch.setTaskstatus("成功");
            dataSearch.setFiletype("" + (start + i));
            dataSearch.setFilepath("" + (start + i));
            dataSearch.setDownaddr("" + (start + i));
            dataSearch.setTelephone("1311234123"+i);
            dataSearch.setTakeparam("" + (start + i));
            dataSearch.setRunparam("" + (start + i));
            dataSearch.setProcenode("" + (start + i));
            dataSearch.setSwitchstate("" + (start + i));
            dataSearch.setDesc("" + (start + i));
            dataSearch.setTotalparam("" + (start + i));
            dataSearchList.add(dataSearch);
        }
        return dataSearchList;
    }


    @Override
    public int getquerySearchCount(String name, String sqlname, String switcsystem,String resource,Date rundate) {
        /*造假数据*/
        return 16;
    }
}
