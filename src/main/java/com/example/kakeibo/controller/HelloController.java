package com.example.kakeibo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // (1)
public class HelloController {
	@RequestMapping("/hello") // (2)
	public String hello() {
		return "Hello World !!";
	}
}