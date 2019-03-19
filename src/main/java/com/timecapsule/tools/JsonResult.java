package com.timecapsule.tools;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

@Component
@JsonInclude(JsonInclude.Include.NON_EMPTY)//@JsonInclude是一种json序列化规则，JsonInclude.Include.NON_EMPTY表示如果范型类中某些属性为空，则这个属性可以不显示
public class JsonResult<T> {
    private int status;//返回的状态
    private String msg;//返回的信息
    private T resultData;//返回的实体类
    public JsonResult() {

    }
    public JsonResult(int status, String msg, T resultData) {
        this.status = status;
        this.msg = msg;
        this.resultData = resultData;
    }
    @Override
    public String toString() {
        return "JsonResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", resultData=" + resultData +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }


}
