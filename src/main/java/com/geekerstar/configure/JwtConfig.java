//package com.geekerstar.configure;
//
//import com.geekerstar.filter.JwtFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author geekerstar
// * date: 2020/01/09 09:28
// * description: JWT拦截器配置，下面配置的是要拦截的URL地址，如果不想拦截，修改掉即可
// */
//@Configuration
//public class JwtConfig {
//
//    @Bean
//    public FilterRegistrationBean jwtFilter() {
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new JwtFilter());
//        registrationBean.addUrlPatterns("/ht/*");
//        return registrationBean;
//    }
//
//}
