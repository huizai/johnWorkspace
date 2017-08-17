package com.cn.hnust.controller;


import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	@RequestMapping(path="/index" , method = RequestMethod.GET)
	public ModelAndView showUser( HttpServletRequest request) {
		System.out.println("111111");
		ModelAndView modle = new ModelAndView();
		modle.setViewName("index");
		return modle;
	}
	
}
