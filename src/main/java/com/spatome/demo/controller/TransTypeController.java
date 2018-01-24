package com.spatome.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spatome.demo.service.TranService;
import com.spatome.util.SpringUtil;

@RestController
@RequestMapping(value = "/process")
public class TransTypeController extends BaseController {

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Object process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String transType = request.getParameter("transType");

		Object bean = SpringUtil.getApplicationContext().getBean("tran"+transType+"ServiceImpl");
		Object result = ((TranService)bean).execute(request, response);

		return result;
	}
}
