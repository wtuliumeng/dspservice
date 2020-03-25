package com.dsp.web.model.datamanage;

public class ColumnVo {
    //标注
    private String label;
    //属性
    private String prop;

    public ColumnVo() {
    }

    public ColumnVo(String label, String prop) {
        this.label = label;
        this.prop = prop;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }
}
