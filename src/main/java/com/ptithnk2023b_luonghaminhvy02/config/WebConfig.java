package com.ptithnk2023b_luonghaminhvy02.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.ptithnk2023b_luonghaminhvy02")
public class WebConfig implements WebMvcConfigurer{
    // cloudinary
    private String HOST_NAME = "dyvpntnlo";
    private String API_KEY = "647263875169227";
    private String API_SECRET = "BZAtIGwSN0iKlvBtkMHjm_NmqDE";

    // config view
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


    // upload server tomcat
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver mResolver = new CommonsMultipartResolver();
        // kích thước tối đa 1 file 10MB
        mResolver.setMaxUploadSizePerFile(1024 * 1024 * 10);
        // kích thước tối đa 1 lần upload tất cả file là 30MB
        mResolver.setMaxUploadSize(1024 * 1024 * 30);
        return mResolver;
    }

    // cloudinary
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", HOST_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET,
                "secure", true
        ));
    }
    // handler resource


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/WEB-INF/css/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("/WEB-INF/js/");

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("/WEB-INF/uploads/");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
