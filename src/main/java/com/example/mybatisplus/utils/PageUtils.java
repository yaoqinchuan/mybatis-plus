package com.example.mybatisplus.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.LocalPage;

import java.util.stream.Collectors;

// todo 分页实现
public class PageUtils {
    public static <T> LocalPage<T> convertToLocalPage(Page<T> sourcePage) {
        LocalPage<T> targetLocalPage = new LocalPage<>();
        targetLocalPage.setPageSize(sourcePage.getSize());
        targetLocalPage.setCount(sourcePage.getRecords().size());
        targetLocalPage.setData(sourcePage.getRecords());
        targetLocalPage.setIndex(sourcePage.getCurrent());
        targetLocalPage.setTotal(sourcePage.getTotal());
        targetLocalPage.setTotalPage(sourcePage.getTotal() % sourcePage.getSize() == 0 ? sourcePage.getTotal() / sourcePage.getSize() : sourcePage.getTotal() / sourcePage.getSize() + 1);
        return targetLocalPage;
    }

    public static <T, U> LocalPage<U> convertToLocalPage(Page<T> sourcePage, Class<U> clazz) {
        LocalPage<U> targetLocalPage = new LocalPage<>();
        targetLocalPage.setPageSize(sourcePage.getSize());
        targetLocalPage.setCount(sourcePage.getRecords().size());
        targetLocalPage.setData(sourcePage.getRecords().stream().map(record -> ConvertUtils.convert(record, clazz)).collect(Collectors.toList()));
        targetLocalPage.setIndex(sourcePage.getCurrent());
        targetLocalPage.setTotal(sourcePage.getTotal());
        targetLocalPage.setTotalPage(sourcePage.getTotal() % sourcePage.getSize() == 0 ? sourcePage.getTotal() / sourcePage.getSize() : sourcePage.getTotal() / sourcePage.getSize() + 1);
        return targetLocalPage;
    }
}
