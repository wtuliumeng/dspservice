package com.dsp.web.service.datamanage.impl;

import com.dsp.web.model.datamanage.ColumnVo;
import com.dsp.web.model.datamanage.DataRetrievalParam;
import com.dsp.web.model.datamanage.DataRetrievalVo;
import com.dsp.web.service.datamanage.DataRetrievalService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataRetrievalServiceImpl implements DataRetrievalService {

    @Override
    public DataRetrievalVo getTableList(DataRetrievalParam param) {
        DataRetrievalVo dataRetrievalVo = new DataRetrievalVo();
        //造假数据
        if("1".equals(param.getSqlId())){
            String str = "button_id,button_name,button_title,button_img,button_code,button_type,button_remark,button_mark,button_date";
            String[] sz = str.split(",");
            List<ColumnVo> cols = new ArrayList<>();
            for(int i = 0;i < sz.length;i++){
                ColumnVo columnVo = new ColumnVo();
                columnVo.setLabel(sz[i]);
                columnVo.setProp(i + "");
                cols.add(columnVo);
            }
            List<Map<String,String>> tableData = new ArrayList<>();
            for(int j = 0;j < 5;j++){
                Map<String,String> map = new HashMap<>();
                for(int i = 0;i < sz.length;i++){
                    map.put(i+"","val" + i*2433 + j*10);
                }
                tableData.add(map);
            }
            dataRetrievalVo.setCols(cols);
            dataRetrievalVo.setTableData(tableData);
            dataRetrievalVo.setCount(5L);
        }else if("2".equals(param.getSqlId())){
            String str = "sql_id,sql_type,sql_name,file_name,file_path,dsi,desc,status,remark,mark,user,create,update,kl,zfb,dly";
            String[] sz = str.split(",");
            List<ColumnVo> cols = new ArrayList<>();
            for(int i = 0;i < sz.length;i++){
                ColumnVo columnVo = new ColumnVo();
                columnVo.setProp(i + "");
                columnVo.setLabel(sz[i]);
                cols.add(columnVo);
            }
            List<Map<String,String>> tableData = new ArrayList<>();
            for(int j = 0;j < 7;j++){
                Map<String,String> map = new HashMap<>();
                for(int i = 0;i < sz.length;i++){
                    map.put(i+"",i + "" + j);
                }
                tableData.add(map);
            }
            dataRetrievalVo.setCols(cols);
            dataRetrievalVo.setTableData(tableData);
            dataRetrievalVo.setCount(7L);
        }else{
            return null;
        }
        return dataRetrievalVo;
    }
}
