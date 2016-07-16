/**
 * This is a configuration class
 * 
 */

package com.jorge.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // This declares it as a Spring configuration class
@EnableWebMvc // This enables Spring's ability to receive and process web requests
@ComponentScan(basePackages = { "com.jorge.controller","com.jorge.service"}) // This scans the com.jorge.controller and
																			 // com.jorge.service package for Spring components
//@Import({ DatabaseConfig.class, SecurityConfig.class }) //If you are using a Spring application without a 'ServletInitializer' class,
														  //you can include other configuration classes from your primary configuration class
public class AppConfig {
	
}
