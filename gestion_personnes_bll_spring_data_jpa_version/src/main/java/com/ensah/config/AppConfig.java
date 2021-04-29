package com.ensah.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ensah.core.bo.Person;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.ensah" })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.ensah.core.dao" })
public class AppConfig implements WebMvcConfigurer {

	private static final Logger LOGGER = Logger.getLogger(AppConfig.class);

	public AppConfig() {

		System.out.println(" configuration init...");

		LOGGER.debug(" configuration init...");
	}

	// set up a logger for diagnostics

	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		return bean;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(getDataSource());
		em.setPackagesToScan(new String[] { "com.ensah.core.bo" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}
	


	@Bean
	public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

	    return transactionManager;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		return properties;
	}

//	@Bean
//	@Autowired
//	public HibernateTemplate hibernateTemplate(final SessionFactory sessionFactory) {
//		System.out.println("SessionFactory..." + sessionFactory);
//		HibernateTemplate hibernateTemplate = new HibernateTemplate();
//		hibernateTemplate.setSessionFactory(sessionFactory);
//
//		if (hibernateTemplate != null) {
//			LOGGER.debug(" HibernateTemplate created ...");
//			System.out.println("HibernateTemplate created ...");
//		}
//
//		return hibernateTemplate;
//	}

//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//
//		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//		sessionFactory.setDataSource(getDataSource());
//		sessionFactory.setHibernateProperties(hibernateProperties());
//
//		sessionFactory.setAnnotatedClasses(Person.class, User.class, Role.class);
//
////		sessionFactory.setAnnotatedPackages("com.ensah.core.bo");
//
//		if (sessionFactory != null) {
//			LOGGER.debug(" sessionFactory created ...");
//		}
//
//		System.out.println("LocalSessionFactoryBean..." + sessionFactory);
//		return sessionFactory;
//	}

//	final Properties hibernateProperties() {
//
//		final Properties hibernateProperties = new Properties();
//
//		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDB53Dialect");
//		hibernateProperties.setProperty("hibernate.show_sql", "true");
//
//		// ....
//
//		return hibernateProperties;
//	}

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/testapp");

		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

//	@Bean
//	@Autowired
//	public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
//		final HibernateTransactionManager txManager = new HibernateTransactionManager();
//		txManager.setSessionFactory(sessionFactory);
//
//		if (txManager != null) {
//			LOGGER.debug(" Hibernate Transaction Manager created ...");
//
//		}
//
//		return txManager;
//
//	}
}