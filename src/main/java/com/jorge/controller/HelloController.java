package com.jorge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jorge.service.UserService;

@Controller // This says this class is a controller
public class HelloController {
	
	@Autowired
	UserService userService; //Using a bean via dependency injection with @Autowired
	
	@Autowired
	private ApplicationContext applicationContext; //Using a bean directly
	
	
	
	/**
	 * Using a bean via dependency injection with @Autowired
	 * 
	 * Spring configuration beans, such as the one in the Defining a bean explicitly with @Bean recipe are
	 * automatically discovered and used by Spring. To use a bean (any kind of bean) in one of your classes,
	 * add the bean as a field and annotate it with @Autowired . Spring will automatically initialize the field
	 * with the bean. In this recipe, we'll use an existing bean in a controller class.
	 * 
	 * Dependency injection is useful when interfaces are used. For example, we could replace our
	 * UserService class by a UserService interface and its implementation UserServiceImpl .
	 * Everything would work the same, except that it's now simple to swap UserServiceImpl for another
	 * class, for example, for unit testing purposes.
	 * 
	 * Try it:
	 * 
	 *  	http://localhost:8080/spring2_webApp/hi
	 *
	 */

	@RequestMapping("hi") // How to call hi() method from URL => http://localhost:8080/spring2_webApp/hi
						  // Takes the route as a parameter- A request with the /hi route will execute the hi() method.
	@ResponseBody // Indicates a method return value should be bound to the web response body
	public String hi() {
		// return "Hello, world.";
		return "<b>nb of users from hi method: " + userService.findNumberOfUsers() + "</b>"; //Using a bean (UserService) via dependency injection with @Autowired
	}																						 //<b> tag bolding answer
	
	
	
	/**
	 * 
	 * Using a bean directly
	 * 
     * It's possible to get a bean directly from Spring instead of using dependency injection by making
     * Spring's ApplicationContext , which contains all the beans, a dependency of your class. In this
     * recipe, we'll inject an existing bean into a controller class.
     * 
     * Try it:
	 * 
	 *  	http://localhost:8080/spring2_webApp/hey
	 *  
	 */
	@RequestMapping("hey")
	@ResponseBody
	public String hey(){
		UserService userService = (UserService)applicationContext.getBean("theBestUserService"); // "theBestUserService" is the name of the @Component in UserService class
																								 // If @Component in UserService class doesn't have name, then it would be this way: ...getBean("userService")
																								 // 'userService' makes reference to UserService.java class name 
		//UserService userService = (UserService)applicationContext.getBean(UserService.class); // It's possible to get a bean by its class, without knowing its name
																							    // It still needs @Component in UserService class
		return "nb of users from hey method: " + userService.findNumberOfUsers();
	}
	
	
	
	/**
	 * 
	 * Listing all beans
	 * 
	 * It can be useful, especially for debugging purposes, to list all the beans at a given moment.
	 *
	 ** Try it:
	 * 
	 *  	http://localhost:8080/spring2_webApp/listBeans
	 *  
	 */
	@RequestMapping("listBeans")
	@ResponseBody
	public String beanList(){
		String[] beans = applicationContext.getBeanDefinitionNames();
		String res = "";
		
		for (String bean : beans) {
			res = res.concat(bean).concat("<br/>"); //<br/> tag makes line break
			System.out.println(bean);
		}
		
		return res;
	}
}
