package cn.polysys.springboot.logindemo.core;

import java.io.Serializable;

/**
 * 用于返回Json结构结果
 *
 * @author hujie
 * @date 2018/04/04
 */
public class Message implements Serializable {
    private static final long serialVersionUID = -8088257719530379886L;
    /**
     * 处理成功或失败状态
     */
    private boolean success;
    /**
     * 自定义状态码，可考虑使用枚举
     */
    private Integer code;
    /**
     * 返回的消息内容
     */
    private String msg;
    /**
     * 返回的数据部分
     */
    private Object data;

    private Message(boolean success) {
        this.success = success;
    }

    private Message(boolean success, String msg) {
        this(success, msg, null);
    }

    private Message(boolean success, String msg, Object data) {
        this(success, msg, data, null);
    }

    private Message(boolean success, String msg, Object data, Integer code) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Message success() {
        return new Message(true);
    }

    public static Message success(String msg) {
        return new Message(true, msg);
    }

    public static Message success(String msg, Object data, Integer code) {
        return new Message(true, msg, data, code);
    }

    public static Message failure() {
        return new Message(false);
    }

    public static Message failure(String msg) {
        return new Message(false, msg);
    }

    public static Message failure(String msg, Integer code) {
        return new Message(false, msg, null, code);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
