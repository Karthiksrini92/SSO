package com.sso.config;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sso.dao.Requester_ContactDAO;
import com.sso.dao.Requester_ContactImpl;
import com.sso.dao.SSODAO;
import com.sso.dao.SSODAOImpl;
import com.sso.dao.Technical_ContactDAO;
import com.sso.dao.Technical_ContactDAOImpl;



@Configuration
@ComponentScan(basePackages="com.sso.controller")
@EnableWebMvc

public class MVCConfiguration extends WebMvcConfigurerAdapter {
	@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=SSO_DB"); //PUT DATABASE NAME HERE INSTEAD OF {Database Name}
        dataSource.setUsername("root");
        dataSource.setPassword("");
         
        return dataSource;
    }
     
    @Bean
    public Technical_ContactDAO getTechContactDAO() {
        return new Technical_ContactDAOImpl(getDataSource());
    }
    @Bean
    public SSODAO getSSODAO() {
        return new SSODAOImpl(getDataSource());
    }
    @Bean
    public Requester_ContactDAO getRequesterContactDAO() {
        return new Requester_ContactImpl(getDataSource());
    }
}
