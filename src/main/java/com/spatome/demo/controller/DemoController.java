package com.spatome.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo")
public class DemoController extends BaseController {

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public Object test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseVO<Object> result = new BaseVO<Object>();

		String id = request.getParameter("id");
		result.setBody(id);
		
		LOGGER.debug("这是Debug");
		LOGGER.info("这是Info");
		LOGGER.error("这是Error");
		
		return result;
	}
}
