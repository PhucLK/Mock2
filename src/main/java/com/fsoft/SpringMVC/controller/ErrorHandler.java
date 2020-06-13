package com.fsoft.SpringMVC.controller;



import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author PhucTV7
 *
 * Version 1.0
 *
 * @date 2020-Jun-06
 *
 * Copyright
 *
 */

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String processException404(Model model) {
		model.addAttribute("errorMessage", "Page not found.");
		model.addAttribute("errorCode", "404");
		return "error-page";
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String processException400(Model model) {
		model.addAttribute("errorMessage", "Bad Request.");
		model.addAttribute("errorCode", "400");
		return "error-page";
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String processException500(Model model) {
		model.addAttribute("errorMessage", "Internal Server Error.");
		model.addAttribute("errorCode", "500");
		return "error-page";
	}

}