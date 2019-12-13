package com.kakaopay.shortening.common.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc config class
 * Created by MHLab on 2019/12/12..
 */

@Configuration
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    //인터셉터 부분은 미 사용
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    //리소스 등록
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
