package com.mall.common.core.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Objects;

/**
 * 服务端统一返回
 *
 * @author cwd
 * @date 2022/3/1 下午9:05
 */
public class ServerResponseEntity<T> implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ServerResponseEntity.class);

    private String code;

    private String msg;

    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public boolean isSuccess() {
        return Objects.equals(ResponseEnum.OK.value(), this.code);
    }

    @Override
    public String toString() {
        return "ServerResponseEntity{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
    }

    public static <T> ServerResponseEntity<T> success(T data) {
        ServerResponseEntity<T> serverResponseEntity = new ServerResponseEntity<>();
        serverResponseEntity.setCode(ResponseEnum.OK.value());
        serverResponseEntity.setData(data);
        return serverResponseEntity;
    }

    public static <T> ServerResponseEntity<T> success() {
        ServerResponseEntity<T> serverResponseEntity = new ServerResponseEntity<>();
        serverResponseEntity.setCode(ResponseEnum.OK.value());
        serverResponseEntity.setMsg(ResponseEnum.OK.getMsg());
        return serverResponseEntity;
    }

    /**
     * 前端显示失败消息
     *
     * @param msg 失败消息
     * @return
     */
    public static <T> ServerResponseEntity<T> showFailMsg(String msg) {
        log.error(msg);
        ServerResponseEntity<T> serverResponseEntity = new ServerResponseEntity<>();
        serverResponseEntity.setMsg(msg);
        serverResponseEntity.setCode(ResponseEnum.SHOW_FAIL.value());
        return serverResponseEntity;
    }

    public static <T> ServerResponseEntity<T> fail(ResponseEnum responseEnum) {
        log.error(responseEnum.toString());
        ServerResponseEntity<T> serverResponseEntity = new ServerResponseEntity<>();
        serverResponseEntity.setMsg(responseEnum.getMsg());
        serverResponseEntity.setCode(responseEnum.value());
        return serverResponseEntity;
    }

    public static <T> ServerResponseEntity<T> fail(ResponseEnum responseEnum, T data) {
        log.error(responseEnum.toString());
        ServerResponseEntity<T> serverResponseEntity = new ServerResponseEntity<>();
        serverResponseEntity.setMsg(responseEnum.getMsg());
        serverResponseEntity.setCode(responseEnum.value());
        serverResponseEntity.setData(data);
        return serverResponseEntity;
    }

    public static <T> ServerResponseEntity<T> transform(ServerResponseEntity<?> oldServerResponseEntity) {
        ServerResponseEntity<T> serverResponseEntity = new ServerResponseEntity<>();
        serverResponseEntity.setMsg(oldServerResponseEntity.getMsg());
        serverResponseEntity.setCode(oldServerResponseEntity.getCode());
        log.error(serverResponseEntity.toString());
        return serverResponseEntity;
    }


}
