package com.java2007.xiazhaodong.hotel.entity;

import java.util.List;

/**
 * 分页基类
 * @Author AzureSky_X
 * @Date 2021/1/25 19:02
 * @Version 1.0
 */
public class PageBean<T> {
    //当前页
    private Integer pageNo;
    //页大小 每页6条记录 写死了
    private Integer pageSize=6;
    //冗余变量，方便取值
    public final static Integer SIZE=6;
    //当前页的数据
    private List<T> list;
    //总条数
    private Long totalCount;
    //总页数 计算得到
    private Long totalPages;

    public PageBean(Integer pageNo, Integer pageSize, List<T> list, Long totalCount, Long totalPages) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.list = list;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
    }

    public PageBean() {
    }

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

    public static Integer getSize() {
        return SIZE;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages() {
        //总页数=总条数 % 页大小，若有余数，总页数+1；若无余数，总页数不变
        this.totalPages = this.totalCount % this.pageSize==0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize+1;
        //this.totalPages = (long)(Math.ceil((double)this.totalCount / this.pageSize));
    }
}
