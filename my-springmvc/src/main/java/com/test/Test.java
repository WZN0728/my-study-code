package com.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web")
public class Test {

	// ���������url����web/test/����д/***.json
	@RequestMapping("test/{url/***.json}")
	public ModelAndView getModelAndView(@RequestParam String name, @PathVariable String url, HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}

}