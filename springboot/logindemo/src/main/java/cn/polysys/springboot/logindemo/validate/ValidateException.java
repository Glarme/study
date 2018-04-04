package cn.polysys.springboot.logindemo.validate;

import cn.polysys.springboot.logindemo.core.Message;

/**
 * 校验异常
 *
 * @author hujie
 * @date 2018/04/04
 */
public class ValidateException extends Exception {
    private static final long serialVersionUID = -821950894034713012L;

    private Message msg;

    ValidateException(Message msg) {
        super(msg.getMsg());
        this.msg = msg;

    }

    public Message getMsg() {
        return msg;
    }
}
