package com.daofab.assignment.serviceobjects;

import java.util.ArrayList;
import java.util.List;

public class PageableData<T> {
    private PaginationInfo paginationInfo;
    private List<T> data;

    public PageableData() {
        this.data = new ArrayList<>();
    }

    public PageableData(PaginationInfo paginationInfo, List<T> data) {
        this.paginationInfo = paginationInfo;
        this.data = data;
    }

    public PaginationInfo getPaginationInfo() {
        return this.paginationInfo;
    }

    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
