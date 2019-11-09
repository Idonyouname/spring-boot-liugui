package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Auther liugui
 * @Create 2019/8/31 16:14
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "spring boot 2.0 hello";
	}
}
