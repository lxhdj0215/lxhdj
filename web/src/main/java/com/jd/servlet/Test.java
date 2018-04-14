package com.jd.servlet;

import java.lang.reflect.Method;

/**
 * Created by wangguijun1 on 2018/4/2.
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException {
        Class cls = Test.class;
        Method method = cls.getMethod("name");
        System.out.println(method.isAccessible());
    }
}
