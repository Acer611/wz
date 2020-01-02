package com.swtl.wz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @program fruit
 * @description: 注册拦截器
 * @author: apple
 * @create: 2018/11/07 16:34
 */

@Configuration
public class WebInterceptionConfig extends WebMvcConfigurationSupport {




    @Bean
    public InterceptorConfig interceptorConfig() {
        return new InterceptorConfig();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        System.out.println("系统启动成功!!");
        System.out.println("进入拦截器.......");
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(interceptorConfig()).addPathPatterns("/user/**").excludePathPatterns("/api/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/").setCachePeriod(0);
        //判断系统
        String os = System.getProperty("os.name");
        if (os != null && os.toLowerCase().indexOf("win") > -1) {
            registry.addResourceHandler("/images/**").addResourceLocations("file:c:/images/");
        } else {
            registry.addResourceHandler("/images/**").addResourceLocations("file:/opt/images/");
        }

        if (os != null && os.toLowerCase().indexOf("win") > -1) {
            registry.addResourceHandler("/banner/**").addResourceLocations("file:c:/images/");
        } else {
            registry.addResourceHandler("/banner/**").addResourceLocations("file:/opt/images/");
        }
    }


}

