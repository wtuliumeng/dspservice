package com.dsp.web.model.datamanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRetrievalVo {
    //表头列
    private List<ColumnVo> cols = new ArrayList<>();
    //表内容数据
    private List<Map<String,String>> tableData = new ArrayList<>();
    //数据总量
    private Long count;

    public DataRetrievalVo() {
    }

    public DataRetrievalVo(List<ColumnVo> cols, List<Map<String, String>> tableData, Long count) {
        this.cols = cols;
        this.tableData = tableData;
        this.count = count;
    }

    public List<ColumnVo> getCols() {
        return cols;
    }

    public void setCols(List<ColumnVo> cols) {
        this.cols = cols;
    }

    public List<Map<String, String>> getTableData() {
        return tableData;
    }

    public void setTableData(List<Map<String, String>> tableData) {
        this.tableData = tableData;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
