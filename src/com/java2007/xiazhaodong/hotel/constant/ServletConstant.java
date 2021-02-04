package com.java2007.xiazhaodong.hotel.constant;

/**
 * 定义常量
 * @Author AzureSky_X
 * @Date 2021/1/22 17:22
 * @Version 1.0
 */
public interface ServletConstant {
    //请求参数对应的功能
    String METHOD="method";
    //转发前缀
    String PRE_FORWARD="forward:";
    //重定向前缀
    String PRE_REDIRECT="redirect:";
    //标识分隔符
    String TAG=":";
    //公共的错误信息
    String COMMON_ERROR_MESSAGE = "<script>alert('服务器正忙，请稍后重试');location.href='/index.jsp'</script>";





}
