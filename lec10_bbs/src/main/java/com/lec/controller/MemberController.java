package com.lec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.service.MemberService;



@RestController
@RequestMapping("/user")
public class MemberController {

	@Autowired
	private MemberService memberService;
}
