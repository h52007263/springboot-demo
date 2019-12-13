package com.example.demo.domain;

import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description Result
 * @date 2019/11/24 23:20
 */

public class Result<T> {
    private Integer pageNo;
    private Integer pageSize;
    private List<T> data;
    private String code;
    private String msg;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
