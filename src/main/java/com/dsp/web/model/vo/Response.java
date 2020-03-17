package com.dsp.web.model.vo;


import com.dsp.web.common.enums.Status;

public class Response {
    public Status status=Status.SUCCESS;
    public String message="执行成功";

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

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * 是否成功
     * @param response
     * @return
     */
    public static Boolean isSucess(Response response){
        if(response.getStatus().getValue().equals(Status.SUCCESS.getValue())){
            return true;
        }
        else {
            return false;
        }
    }
}
