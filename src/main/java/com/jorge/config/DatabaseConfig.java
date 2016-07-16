/**
 * Defining a bean explicitly with @Bean 
 * 
 * The simplest way to define a bean is to create, in a Spring configuration class, a method annotated
 * with @Bean returning an object (the actual bean). Such beans are usually used to configure Spring in
 * some way (database, security, view resolver, and so on).
 * 
 * This is a configuration class
 * 
 */
package com.jorge.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration // This declares it as a Spring configuration class
public class DatabaseConfig {
	@Bean(name="theSource") // To customize the bean name, use the 'name' parameter
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // By default, beans in Spring are Singleton. 
													// To force dataSource() to be executed each time 
													// it's called (and return a different object each time)
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		return dataSource;
	}
}
