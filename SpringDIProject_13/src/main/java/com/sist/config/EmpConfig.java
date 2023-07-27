package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration		// xml을 java로 변경
//<context:component-scan base-package="com.sist.*"></context:component-scan>
@ComponentScan(basePackages = "com.sist.*")
//<mybatis-spring:scan base-package="com.sist.mapper2"/>
@MapperScan(basePackages = "com.sist.mapper2")
public class EmpConfig {

	/*
	 * 메모리 할당 받는 애들
	 * @Component, @Repository, @Service, @Controller, @RestController, @ControllerAdvice, 
 		@Configuration
	 */
	
	@Bean("ds")
	public DataSource dataSource() {
		/*
		 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
				p:driverClassName="oracle.jdbc.driver.OracleDriver"
				p:url="jdbc:oracle:thin:@localhost:1521:XE"
				p:username="hr"
				p:password="happy"
			/>
		 */
		BasicDataSource ds=new BasicDataSource();
		
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		
		return ds;
		
	}
	
	/*
	 * mybatis 전송
		<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
			p:dataSource-ref="ds"

	 */
	
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	
}
