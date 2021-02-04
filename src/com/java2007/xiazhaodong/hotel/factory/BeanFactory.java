package com.java2007.xiazhaodong.hotel.factory;

import java.util.ResourceBundle;

/**
 * @Author AzureSky_X
 * @Date 2021/1/19 20:24
 * @Version 1.0
 * 工厂：创建dao或service的实例
 */
public class BeanFactory {
    ////ResourceBundle的作用：本地化加载配置文件中的内容
    ////加载配置文件
    //private static ResourceBundle bundle;
    ////只加载一次
    //static {
    //    bundle=ResourceBundle.getBundle("instance");
    //}
    //
    ///**
    // * 根据指定的key，读取配置文件获取类的全路径，通过反射创建对象
    // * @param key         需要创建实例的对象
    // * @param clazz       需要创建实例的对象的类对象
    // * @param <T>         需要创建实例的对象的：类型
    // * @return
    // */
    //public static <T> T getInstance(String key,Class<T> clazz){
    //    String className=bundle.getString(key);
    //    try {
    //        return (T) Class.forName(className).newInstance();
    //    } catch (Exception e) {
    //        throw new RuntimeException(e);
    //    }
    //
    //}
    public static Object getBean(String className){
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
