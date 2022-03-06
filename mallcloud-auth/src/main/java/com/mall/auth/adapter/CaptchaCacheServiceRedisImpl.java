package com.mall.auth.adapter;

import com.anji.captcha.service.CaptchaCacheService;

/**
 * 适配验证码在redis的存储
 * @author cwd
 * @date 2022/3/6 下午4:43
 */
public class CaptchaCacheServiceRedisImpl implements CaptchaCacheService {
    @Override
    public void set(String s, String s1, long l) {
        RdisU
    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public String get(String s) {
        return null;
    }

    @Override
    public String type() {
        return null;
    }
}
