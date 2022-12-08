package com.ssyedhamed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/home")
	public String hello() {
		return "hello";
	}
}
