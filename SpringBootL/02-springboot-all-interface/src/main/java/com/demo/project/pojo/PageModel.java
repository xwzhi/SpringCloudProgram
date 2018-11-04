package com.demo.project.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageModel
 * @Description
 * @Author XWZ
 * @Date Create In 2018/8/13 00:49: 星期一 web
 * @Version 1.0.0
 **/
public class PageModel<T> implements Serializable {

    private static final long serialVersionUID=1L;

    //总记录数
    private Integer total;
    //每页大小
    private Integer pageSize;
    //记录
    private List<T> rows;
    //地址
    private String url;
    //当前页
    private Integer page;
    //起始行
    private Integer startRow;
    //起始页
    private Integer startPage;
    //最后一页
    private Integer endPage;
    //总页数
    private Integer pageNum;

    public PageModel(Integer page, Integer pageSize, Integer total){
        this.startRow=(page-1)*pageSize;
        this.page=page;
        this.pageSize=pageSize;
        this.total=total;
        this.pageNum=total/pageSize;
        int x=total%pageSize;
        if(x>0){
            this.pageNum=total/pageSize+1;
        }
    }
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer currentPage) {
        this.page = currentPage;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getStartPage() {
        if((page-5)<1){
            this.startPage=1;
        }else{
            this.startPage=page-5;
        }
        return startPage;
    }

    public void setStartPage(Integer startPage) {
       this.startPage=startPage;
    }

    public Integer getEndPage() {
        if((page+5)>pageNum){
            this.endPage=pageNum;
        }else{
            this.endPage=page+5;
        }
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage=endPage;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "total=" + total +
                ", pageSize=" + pageSize +
                ", rows=" + rows +
                ", url='" + url + '\'' +
                ", currentPage=" + page +
                ", startRow=" + startRow +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                '}';
    }
}
