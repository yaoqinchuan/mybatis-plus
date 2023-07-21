package com.example.mybatisplus.common;

import org.springframework.beans.BeanUtils;

public class ConvertUtils {
    public static <T> T convert(Object object, Class<T> clazz){
        T target = null;
        try {
            target = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(object, target);
        return target;
    }
}
