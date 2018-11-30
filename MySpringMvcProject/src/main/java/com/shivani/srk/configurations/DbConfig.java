package com.shivani.srk.configurations;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:dbConfig.properties")
@ComponentScan({"com.shivani.srk"})
public class DbConfig {

	@Autowired
	private Environment env;	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		try {				
			final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
			entityManagerFactoryBean.setJpaVendorAdapter(getJpaVendorAdapter());
			entityManagerFactoryBean.setDataSource((javax.sql.DataSource) getDataSource());
			entityManagerFactoryBean.setPersistenceUnitName("myJpaPersistenceUnit");
			entityManagerFactoryBean.setPackagesToScan("com.shivani.srk");
			entityManagerFactoryBean.setJpaProperties(jpaProperties());
			return entityManagerFactoryBean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		return adapter;
	}

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		return  dataSource;
	}

	//		 @Bean
	//		   public DataSource getDataSource() {
	//		     final BasicDataSource dataSource = new BasicDataSource();
	//		      dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	//		      dataSource.setUrl(env.getProperty("jdbc.url"));
	//		      dataSource.setUsername(env.getProperty("jdbc.user"));
	//		      dataSource.setPassword(env.getProperty("jdbc.pass"));
	//		      return dataSource;
	//		   }

	//		@Bean
	//		public PlatformTransactionManager txManager(){
	//			JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
	//					getEntityManagerFactoryBean().getObject());
	//			return jpaTransactionManager;
	//		}
	//		

	@Bean
	public JpaTransactionManager geJpaTransactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
		return transactionManager;
	}



	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		return properties;        
	}	


	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520);   // 20MB
		multipartResolver.setMaxInMemorySize(1048576);  // 1MB
		return multipartResolver;
	}
} 



