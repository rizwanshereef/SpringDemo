package com.stackroute.spring.mvc.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.spring.mvc.model.IPolicy;

@Configuration
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean
	public DataSource GetDataSource() {

		BasicDataSource datasource = new BasicDataSource();

		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/policydb");
		datasource.setUsername("root");
		datasource.setPassword("root");

		return datasource;

	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) throws IOException {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

		sessionFactoryBean.setDataSource(dataSource);

		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");

		sessionFactoryBean.setHibernateProperties(properties);
		sessionFactoryBean.setAnnotatedClasses(IPolicy.class);
		sessionFactoryBean.afterPropertiesSet();

		return sessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager tmanager = new HibernateTransactionManager();
		tmanager.setSessionFactory(sessionFactory);
		return tmanager;
	}
}
