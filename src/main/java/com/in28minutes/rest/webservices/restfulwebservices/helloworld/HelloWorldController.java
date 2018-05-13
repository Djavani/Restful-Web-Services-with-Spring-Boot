package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	// GET
	// URI - /hello-world
	// method - "Hello World"
	// @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";

	}

	// hello
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String worldInternationalize() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

	// hello-world/path-variable/Diego
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorlPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World Bean, %s", name));

	}

}
