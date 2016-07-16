/**
 * Defining a bean implicitly with @Component
 * 
 * Beans don't have to be defined in a Spring configuration class. Spring will automatically generate a
 * bean from any class annotated with @Component.
 * 
 * At startup, the com.springcookbook.service package will be scanned by Spring. The
 * UserService class is annotated with @Component , so a bean is automatically instantiated from it.
 * The bean's name will be userService by default, based on the class name.
 *
 */

package com.jorge.service;

import org.springframework.stereotype.Component;

@Component("theBestUserService") // To specify a custom name, use the following code
public class UserService {
	
	public int findNumberOfUsers() {
		return 10;
	}
	
}
