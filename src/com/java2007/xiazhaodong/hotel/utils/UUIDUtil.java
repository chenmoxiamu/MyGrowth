package com.java2007.xiazhaodong.hotel.utils;

import java.util.UUID;

/**
 * UUID文件名生成工具类
 * 生成一个带UUID前缀的新文件名
 * @Author AzureSky_X
 * @Date 2021/1/23 17:46
 * @Version 1.0
 */
public class UUIDUtil {
    //传入后缀名，生成一个带UUID前缀的新文件名
    public static String getFileName(String suffixName){
        //去除UUID前缀中的 “-” 符号
        return UUID.randomUUID().toString().replaceAll("-","")+suffixName;
    }
}
