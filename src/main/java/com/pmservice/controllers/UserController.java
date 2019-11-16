package com.pmservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/user")
public class UserController {

	@GetMapping(path="/hello")
	public @ResponseBody String getHelloMsg() {
		return "Hello";
	}
}
