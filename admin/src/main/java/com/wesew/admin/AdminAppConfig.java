package com.wesew.admin;

import com.wesew.core.services.FileManager;
import com.wesew.core.services.UnixFileManager;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;

/**
 * @author vladyslav.yemelianov
 */
@Configuration
@ComponentScan("com.wesew.admin")
@EnableJpaRepositories(basePackages = "com.wesew.core.repo")
@EnableTransactionManagement
@EnableWebMvc
@Import({RepositoryConfig.class})
@PropertySource(value="classpath:wesew-admin-config.properties")
public class AdminAppConfig extends WebMvcConfigurerAdapter {

    @Value(value = "app.encoding")
    private String encoding;
    @Value(value = "app.images")
    private String baseImageDirPath;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/view/jsp/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding(encoding);
        return resource;
    }

    @Bean(name = "dozerBean")
    public DozerBeanMapperFactoryBean configDozer() throws IOException {
        DozerBeanMapperFactoryBean mapper = new DozerBeanMapperFactoryBean();
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:dozer-mappings.xml");
        mapper.setMappingFiles(resources);
        return mapper;
    }

    @Bean
    public FileManager fileManager() {
        return new UnixFileManager(baseImageDirPath);
    }

}
