package neatlogic.module.springboot.config;

import neatlogic.framework.filter.JsonWebTokenValidFilter;
import neatlogic.framework.listener.ThreadlocalClearListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@ImportResource("classpath:META-INF/root-context.xml")
@Import(DisableFilterAutoConfiguration.class)
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private JsonWebTokenValidFilter jsonWebTokenValidFilter;

    @Bean
    public ServletListenerRegistrationBean<ThreadlocalClearListener> threadlocalClearListener() {
        ServletListenerRegistrationBean<ThreadlocalClearListener> registrationBean = new ServletListenerRegistrationBean<>(new ThreadlocalClearListener());
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilterRegistrationBean() {
        FilterRegistrationBean<CharacterEncodingFilter> registrationBean = new FilterRegistrationBean<>();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setForceRequestEncoding(true);
        characterEncodingFilter.setForceResponseEncoding(true);
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<JsonWebTokenValidFilter> jsonWebTokenValidFilterRegistrationBean() {
        FilterRegistrationBean<JsonWebTokenValidFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jsonWebTokenValidFilter);
        registrationBean.addUrlPatterns("/api/*"); // 设置过滤器应用的URL模式
        return registrationBean;
    }

}
