package com.java2007.xiazhaodong.hotel.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * 密码使用MD5加密，此加密不可逆
 * @Author AzureSky_X
 * @Date 2021/1/26 19:49
 * @Version 1.0
 */
public class MD5Utils {
    public static String md5(String password){
        //生成一个md5加密器
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //计算MD5 的值
            md.update(password.getBytes());
            //BigInteger 将8位的字符串 转成16位的字符串 得到的字符串形式是哈希码值
            //BigInteger(参数1,参数2) 参数1 是 1为正数 0为0 -1为负数
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(MD5Utils.md5("xzd"));
        }
    }
}
