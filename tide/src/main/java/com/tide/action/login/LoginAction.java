package com.tide.action.login;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Component
public class LoginAction {

	@PostConstruct
	public void sss(){
		System.out.println("sssss");
	}
	
	@RequestMapping("/haitao")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        System.out.println("haitao");
        //return "helloWorld";
        return "tao";
    }
	
}
