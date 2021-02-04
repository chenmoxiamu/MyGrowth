package com.java2007.xiazhaodong.hotel.entity;

/**
 * 返回结果的基类
 * @Author AzureSky_X
 * @Date 2021/1/28 17:47
 * @Version 1.0
 */
public class Result {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 回调信息
     */
    private String message;
    /**
     * 传输数据
     */
    private Object data;

    public Result() {
    }

    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result ok(String message){
        return new Result(true,message,null);
    }
    public static Result ok(String message,Object data){
        return new Result(true,message,data);
    }
    public static Result fail(String message){
        return new Result(false,message,null);
    }
    public static Result fail(String message,Object data){
        return new Result(false,message,data);
    }

}
