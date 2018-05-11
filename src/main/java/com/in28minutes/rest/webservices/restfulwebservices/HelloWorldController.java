package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

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

	// hello-world/path-variable/Diego
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorlPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World Bean, %s", name));

	}

}
