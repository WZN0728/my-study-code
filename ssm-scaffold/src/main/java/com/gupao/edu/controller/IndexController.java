package com.gupao.edu.controller;

import com.gupao.edu.controller.support.ResponseData;
import com.gupao.edu.controller.support.ResponseEnum;
import org.api.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.user.api.IUserLoginService;
import org.user.api.dto.UserLoginRequest;
import org.user.api.dto.UserLoginResponse;

import javax.servlet.http.HttpServletRequest;

/**
 */
@Controller
@RequestMapping("/index/")
public class IndexController extends BaseController {

	@Autowired
	IOrderService orderServices;

	@Autowired
	IUserLoginService userService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null) {
			return "/login";
		}
		return "/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "/login";
	}

	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData submitLogin(HttpServletRequest request, String loginname, String password) {
		UserLoginRequest request1 = new UserLoginRequest();
		request1.setUsername(loginname);
		request1.setPassword(password);
		UserLoginResponse response = userService.login(request1);
		if ("111111".equals(response.getCode())) {
			request.getSession().setAttribute("user", "user");
			return setEnumResult(ResponseEnum.SUCCESS, "/");
		}
		ResponseData data = new ResponseData();
		data.setMessage(response.getMessage());
		data.setStatus(ResponseEnum.FAILED.getCode());
		return data;
	}

	/**
	 * 閫�鍑�
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		try {
			request.getSession().removeAttribute("user");
		} catch (Exception e) {
			LOG.error("errorMessage:" + e.getMessage());
		}
		return redirectTo("/index/login.shtml");
	}
}
