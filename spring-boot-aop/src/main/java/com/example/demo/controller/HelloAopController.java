package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Auther liugui
 * @Create 2019/8/29 19:36
 */
@RestController
@RequestMapping("/demo")
public class HelloAopController {

	@GetMapping("/hello")
	public String hello(){
		return "hello aop";
	}


}
