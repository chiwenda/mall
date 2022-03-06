package com.mall.common.core.exception;

import com.mall.common.core.response.ResponseEnum;

/**
 * 统一异常
 *
 * @author cwd
 * @date 2022/3/6 下午4:55
 */
public class MallException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Object object;

    private ResponseEnum responseEnum;

    public MallException(String msg) {
        super(msg);
    }

    public MallException(String msg, Object object) {
        super(msg);
        this.object = object;
    }

    public MallException(String msg, Throwable cause) {
        super(msg, cause);
    }


    public MallException(ResponseEnum responseEnum) {
        super(responseEnum.getMsg());
        this.responseEnum = responseEnum;
    }

    public MallException(ResponseEnum responseEnum, Object object) {
        super(responseEnum.getMsg());
        this.responseEnum = responseEnum;
        this.object = object;
    }


    public Object getObject() {
        return object;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }
}
