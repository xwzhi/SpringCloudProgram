package com.py.property.enums;

/**
 * @ClassName StatusEnum
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-30 16:02 星期二 MyPrograms
 * @VERSION 1.0.0
 **/
public enum StatusEnum {

    ERROR(0, "{\"status\":\"error\"}"),
    SUCCESS(1, "{\"status\":\"success\"}");

    private Integer code;
    private String status;

    StatusEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
