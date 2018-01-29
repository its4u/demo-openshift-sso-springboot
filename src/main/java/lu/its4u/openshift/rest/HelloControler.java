package lu.its4u.openshift.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest API for Hello Wolrd.
 * 
 * @author jerome.cristante
 *
 */
@RestController
@RequestMapping("/rest")
public class HelloControler {


	/**
	 * Dummy method to say hello.
	 * 
	 * @return
	 */
	@RequestMapping("hello")
	public String sayHello() {
		return ("Hello, SpringBoot on Openshift");
	}

}