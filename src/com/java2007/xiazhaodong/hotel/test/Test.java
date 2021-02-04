package com.java2007.xiazhaodong.hotel.test;

import java.util.Date;

/**
 * 测试类
 * @Author AzureSky_X
 * @Date 2021/1/28 10:24
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

        String utl="/front/detail/style/images/shuijiao.jpg";
        Double a1=1.234;
        Float a2= (float) 1.234;
        int i2 = a2.intValue();
        Double b1= Double.valueOf("1234.56");
        double c1=123.4;
        int i = b1.intValue();

        Long b2= Long.valueOf(1234);
        int i1 = b2.intValue();

        Date date=new Date();
        java.sql.Date date1=new java.sql.Date(1000000000);
        long date3 = date.getTime();
        java.sql.Date date4=new java.sql.Date(date3);

        System.out.println("Float-------"+i2);
        System.out.println("Double------"+i);
        System.out.println("Long------"+i1);

        System.out.println("date---------"+date);
        System.out.println("date1---------"+date1);
        System.out.println("date3---------"+date3);
        System.out.println("date4---------"+date4);
        System.out.println(System.currentTimeMillis());

    }
}
