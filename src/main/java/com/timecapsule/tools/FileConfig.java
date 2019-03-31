package com.timecapsule.tools;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FileConfig {

    public class WebMvcConfig extends WebMvcConfigurerAdapter {

        //文件磁盘图片url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");
//            registry.addResourceHandler("/upload/**").addResourceLocations("file:///C:\\Users\\Administrator\\IdeaProjects\\timecapsule\\target\\classes\\upload\\");
        }
    }
}
