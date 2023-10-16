package com.in48hours.springboot.startlearnapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayhello";
	}
}
