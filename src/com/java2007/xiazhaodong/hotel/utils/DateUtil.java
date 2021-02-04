package com.java2007.xiazhaodong.hotel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * String与Date之间的相互转换
 * @Author AzureSky_X
 * @Date 2021/1/26 19:42
 * @Version 1.0
 */
public class DateUtil {
    /**
     * Date转字符串
     * @param date
     * @param pattern   转换格式
     * @return
     */
    public static String dateToStr(Date date,String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 字符串你转时间
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date strToDate (String dateStr,String pattern){
        try {
            return new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("时间格式转换异常");
        }
        return null;
    }



}
