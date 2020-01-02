package com.swtl.wz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @see  项目启动类
 * @author  Gaofei
 * @Date  2018-10-30
 */
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class WZpplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(WZpplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WZpplication.class);
    }
}
