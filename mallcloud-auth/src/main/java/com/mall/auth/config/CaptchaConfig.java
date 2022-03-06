package com.mall.auth.config;

import com.anji.captcha.model.common.CaptchaTypeEnum;
import com.anji.captcha.model.common.Const;
import com.anji.captcha.service.CaptchaService;
import com.anji.captcha.service.impl.CaptchaServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 验证码配置
 *
 * @author cwd
 * @date 2022/3/1 下午8:51
 */
@Configuration
public class CaptchaConfig {


    @Bean
    public CaptchaService captchaService() {
        Properties config = new Properties();
        config.put(Const.CAPTCHA_CACHETYPE, "redis");
        config.put(Const.CAPTCHA_WATER_MARK, "");
        //滑动验证
        config.put(Const.CAPTCHA_TYPE, CaptchaTypeEnum.BLOCKPUZZLE.getCodeValue());
        return CaptchaServiceFactory.getInstance(config);
    }
}
