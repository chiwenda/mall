package com.mall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 网关跨域配置
 *
 * @author cwd
 * @date 2022/3/6 下午1:48
 */
@Configuration
public class CorsConfig {



    @Bean
    public CorsWebFilter corsWebFilter() {
        //基于url跨域
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //配置跨域信息
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许所有请求头
        corsConfiguration.addAllowedHeader("*");
        //允许所有请求方法
        corsConfiguration.addAllowedMethod("*");
        //允许所有请求源
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.setAllowCredentials(true);

        //配置任意url都要跨域
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }
}
