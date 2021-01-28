package br.com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebAppController {
	
	  @RequestMapping(value="/",method = RequestMethod.GET)
	    public ModelAndView index() {
	        ModelAndView mv=new ModelAndView("welcome");
	       return mv;
	        
	      
	    } 

}
