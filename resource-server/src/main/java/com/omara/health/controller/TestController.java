package com.omara.health.controller;

import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test")
	public String test() {
		return "Hello World";
	}

	@RequestMapping("/Patient/{id}/_history/{his} ")
	public String patient(@PathVariable String id,@PathVariable String his) {
		return "Hello World" + id + his;
	}


	@RequestMapping(value = "/test/Patient/{id}", method = RequestMethod.PUT)
	public String testPut(@PathVariable int id){
		return "";
	}
	@RequestMapping("/test/Patient/{id}")
	public String testNew() {
		return "Hello World";
	}
}
