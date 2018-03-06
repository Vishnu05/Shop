package com.moxman.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class exceptiongobal {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlingerror() {
		
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "the page could not be found");
		mv.addObject("errordescription", "the is not avaialable");
		
		return mv;
	}

	@ExceptionHandler(productexception.class)
	public ModelAndView prohandlingerror() {
		
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "the page could not be found");
		mv.addObject("errordescription", "the is not avaialable");
		mv.addObject("title","404 error page" );
		return mv;
	}

}
