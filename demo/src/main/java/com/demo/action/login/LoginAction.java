package com.demo.action.login;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAction {

	@RequestMapping("/haitao.do")
	public String login(){
		HttpServletRequest r=null;
		r.getServerName();
		r.getServerPort();
		r.getServletPath();
		HttpServletResponse p=null;
		System.out.println("sssss");
		return "tao";
	}
	
}
