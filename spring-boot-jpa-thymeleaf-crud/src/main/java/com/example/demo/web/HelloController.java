package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Auther liugui
 * @Create 2019/8/31 16:24
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "hello";
	}

}
