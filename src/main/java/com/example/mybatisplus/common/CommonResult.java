package com.example.mybatisplus.common;

import  com.example.mybatisplus.eums.CommonResultCodeEnums;
import lombok.Data;

@Data
public class CommonResult<T> {
    private T data;
    private String code;
    private String status;
    public static<T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<T>();
        result.data=data;
        result.code= CommonResultCodeEnums.SUCCESS.getCode();
        result.status = "success";
        return result;
    }
    public static<T> CommonResult<T> failed(T data) {
        CommonResult<T> result = new CommonResult<T>();
        result.data=data;
        result.code= CommonResultCodeEnums.FAILED.getCode();
        result.status = "failed";
        return result;
    }
    public static<T> CommonResult<T> failed(T data, String code) {
        CommonResult<T> result = new CommonResult<T>();
        result.data=data;
        result.code= code;
        result.status = "failed";
        return result;
    }
}
