package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// spring에서 클래스 등록
@Configuration
// <context:component-scan base-package="com.sist.*/"/>	
@ComponentScan(basePackages = {"com.sist.*"})
@MapperScan(basePackages = {"com.sist.mapper"})
public class SpringConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
			
		configurer.enable();
		
	}

	/*
	 *	XML 없이 코딩하기
	 *
	 *	- XML
	 *	DispatcherServlet => HandlerMapping / HandlerAdapter (메모리 할당)
	 *
	 *	요청 : .do
	 *		Dispatcher
	 *			= HandlerAdapter : Model 클래스 찾기
	 *			= HandlerMapping : @Get,Post,Request Mapping 찾기 => 호출
	 *
	 *		Dispatcher
	 *			=> request를 ViewResolver 전솔
	 *							 ㅣ
	 *						   JSP 전송 
	 *
	 *
	 *	1. <context:component-scan base-package="com.sist./"/>	
	 *		
	 *	2. mapper 등록
	 *
	 *	3.
	 *	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver"
			p:prefix="/"
			p:suffix=".jsp"
		/>
	 *
	 *	3. 
	 *		<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"
			/>
	 *
	 */
	
	
	@Bean("viewResolver")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver iv=new InternalResourceViewResolver();
		iv.setPrefix("/");
		iv.setSuffix(".jsp");
		return iv;
	}
	
	@Bean("multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver cr=new CommonsMultipartResolver();
		return cr;
	}
	
	@Bean("ds")
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		ds.setMaxActive(10);
		ds.setMaxIdle(10);
		ds.setMaxWait(-1);
		
		return ds;
	}
	
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	
}
