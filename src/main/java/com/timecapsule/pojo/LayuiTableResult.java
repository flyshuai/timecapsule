package com.timecapsule.pojo;

import lombok.Data;

@Data
public class LayuiTableResult<T> {
	private String msg;
    private  T data;
    private  int code;
    private  int count;
    public LayuiTableResult(String msg, T data, int code, int count) {
        this.msg = msg;
        this.data = data;
        this.code = code;
        this.count = count;
    }

    public LayuiTableResult() {
    }

}
