package com.py.property.enums;

/**
 * @ClassName ItemEnum
 * @Author XuWeiZhi
 * @Description 管理类枚举
 * @Date 2018-11-02 09:33 星期五 property
 * @VERSION 1.0.0
 **/
public enum ItemEnum {

    DETAILS(0,"详细","未提交"),
    COMMIT(1,"提交","待审核"),
    EXAMINESUCCESS(2,"审核","审核通过"),
    EXAMINEFAIL(3,"审核","审核未通过"),
    EDIT(4,"编辑","未定"),
    DELETE(4,"删除","未定"),
    ENCLOSURE(4,"附件管理","未定"),
    MOVEUP(4,"上移","未定"),
    MOVEDOWN(4,"下移","未定"),
    ;


    private Integer CODE;

    private String OPERATION;

    private String STATUS;

    ItemEnum(Integer CODE, String OPERATION, String STATUS) {
        this.CODE = CODE;
        this.OPERATION = OPERATION;
        this.STATUS = STATUS;
    }

    public Integer getCODE() {
        return CODE;
    }

    public String getOPERATION() {
        return OPERATION;
    }

    public String getSTATUS() {
        return STATUS;
    }
}
