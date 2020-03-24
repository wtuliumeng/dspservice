package com.dsp.web.model.vo;

/**
 * 下拉框返回实体
 */
public class SelectModelVo {
    //文本标准
    String label;
    //值
    String value;
    //类型
    String type;

    public SelectModelVo() {
    }

    public SelectModelVo(String label, String value, String type) {
        this.label = label;
        this.value = value;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
