package com.curry.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author RUIWU
 * @create 2020-11-25 15:12
 */
public class WebUtils {
    /**
     * 把请求参数注入到Bean中
     * @param value
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            /**
             * 把所有请求的参数都注入到user对象中
             */
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String str){
        return Integer.parseInt(str);
    }

    public static double parseDouble(String str, double defaultValue){
        if (str == ""){
            return defaultValue;
        }
        return Double.parseDouble(str);
    }

    public static int parseInt(String str, int defaultValue){
        if (str == null){
            return defaultValue;
        }
        return Integer.parseInt(str);
    }
}
