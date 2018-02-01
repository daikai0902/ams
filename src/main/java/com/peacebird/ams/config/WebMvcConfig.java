package com.peacebird.ams.config;

import com.peacebird.ams.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by daikai on 2017/9/20.
 */

@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Autowired
    LoginInterceptor loginInterceptor;


    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/loginPage","/user/**");
    }


    /**
     * 静态资源注册
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        //这里swagger的静态资源路径和项目静态资源路径不一致，所以要单独配置
        registry.addResourceHandler("swagger-ui.html") .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
