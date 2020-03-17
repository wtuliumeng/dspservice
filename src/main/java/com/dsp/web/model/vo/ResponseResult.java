package com.dsp.web.model.vo;




import com.dsp.web.common.enums.Status;

import java.util.ArrayList;
import java.util.List;


public class ResponseResult<T> {
    /*消息状态*/
    public Status status;
    /*消息描述*/
    public String message;
    /*返回数据列表*/
    public List<T> dataList = new ArrayList();
    /*返回单条数据*/
    public T data;
    /*分页查询时数据总数*/
    public Integer count;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", dataList=" + dataList +
                ", data=" + data +
                ", count=" + count +
                '}';
    }

    /**
     * 是否成功
     *
     * @param response
     * @return
     */
    public static Boolean isSucess(ResponseResult response) {
        if (response.getStatus().getValue().equals(Status.SUCCESS.getValue())) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isSucess() {
        if (status.getValue().equals(Status.SUCCESS.getValue())) {
            return true;
        } else {
            return false;
        }
    }

    public ResponseResult() {
        this.status = Status.SUCCESS;
        this.message = "成功";
    }
}
