package com.demo.project.model;

import java.io.Serializable;

public class BaseDict implements Serializable {
    private Integer dictId;

    private String dictTypeCode;

    private String dictTypeName;

    private String dictItemName;

    private Integer dictSort;

    private String dictEnable;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode == null ? null : dictTypeCode.trim();
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName == null ? null : dictTypeName.trim();
    }

    public String getDictItemName() {
        return dictItemName;
    }

    public void setDictItemName(String dictItemName) {
        this.dictItemName = dictItemName == null ? null : dictItemName.trim();
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictEnable() {
        return dictEnable;
    }

    public void setDictEnable(String dictEnable) {

        this.dictEnable = dictEnable == null ? null : dictEnable.trim();
    }

    @Override
    public String toString() {
        return "BaseDict{" +
                "dictId=" + dictId +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", dictTypeName='" + dictTypeName + '\'' +
                ", dictItemName='" + dictItemName + '\'' +
                ", dictSort=" + dictSort +
                ", dictEnable='" + dictEnable + '\'' +
                '}';
    }
}