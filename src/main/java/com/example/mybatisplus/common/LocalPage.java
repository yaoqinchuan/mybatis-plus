package com.example.mybatisplus.common;

import lombok.Data;

import java.util.List;

@Data
public class LocalPage<T> {
    private Long pageSize;
    private Long total;
    private Long totalPage;
    private Long index;
    private Integer count;
    private List<T> data;
}
