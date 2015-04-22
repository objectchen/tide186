package com.demo.action.login;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAction {

	@RequestMapping("/haitao.do")
	public String login(){
		System.out.println("sssss");
		return "tao";
	}
	
}
