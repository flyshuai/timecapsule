package com.timecapsule.config;

import com.timecapsule.tools.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    /**
     * 注册 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置拦截的路径、不拦截的路径、优先级等等
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*").
                excludePathPatterns("/toIndex","/toRegister","/toLoginN","/login","/register","/loginOut");
    }
}