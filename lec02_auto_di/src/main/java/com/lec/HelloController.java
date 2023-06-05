package com.lec;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "홍길동");
		return "hello";
	}
}
