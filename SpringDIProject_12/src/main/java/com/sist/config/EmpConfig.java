package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// xml 대신 어노테이션으로 대체

@Configuration
// <
@ComponentScan(basePackages = "com.sist.*")
@MapperScan(basePackages = "com.sist.mapper")
public class EmpConfig {

	
	/*
	 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
			p:driverClassName="oracle.jdbc.driver.OracleDriver"
			p:url="jdbc:oracle:thin:@localhost:1521:XE"
			p:username="hr"
			p:password="happy"
		/>
		
		<!-- mybatis 전송 -->
		<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
			p:dataSource-ref="ds"
			p:configLocation="classpath:Config.xml"
/>
	 */
	
	// 위 코딩이 아래 자바 형식으로 바뀌었다 => 보안
	
	@Bean("ds")
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	 
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		
		return ssf.getObject();
	}
}
