package com.cn.hnust.util;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 总的记录条数
     */
    private int totalRecord;

    /**
     * 记录列表
     */
    private List<?> records;
    /**
     * 页码
     */
    private int pageNo = 1;

    /**
     * 每页显示长度
     */
    private int pageSize = 10;

    /**
     * 分页开始
     */
    private String start;

    /**
     * 分页结束
     */
    private String end;

    public String getEnd()
    {
        end = String.valueOf((pageNo * pageSize));
        return end;
    }

    public String getStart()
    {
        start = String.valueOf(((pageNo - 1) * pageSize));
        return start;
    }

    public int getTotalRecord()
    {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord)
    {
        this.totalRecord = totalRecord;
    }

    public List<?> getRecords()
    {
        return records;
    }

    public void setRecords(List<?> records)
    {
        this.records = records;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
