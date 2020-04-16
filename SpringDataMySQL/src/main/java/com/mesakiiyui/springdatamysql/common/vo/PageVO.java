package com.mesakiiyui.springdatamysql.common.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {
    private int currentPage;
    private int totalPage;
    private List<T> data;

    public PageVO(){
        super();
    }

    public PageVO(int currentPage, int totalPage, List<T> data) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.data = data;
    }
}
