package com.spatome.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spatome.demo.service.CmdService;
import com.spatome.util.SpringUtil;

@RestController
@RequestMapping(value = "/process")
public class TransTypeController extends BaseController {

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Object process(@RequestBody Map<String, String> maps) throws Exception {
		String cmd = maps.get("cmd");

		Object bean = SpringUtil.getApplicationContext().getBean("cmd"+cmd+"ServiceImpl");
		Object result = ((CmdService)bean).execute(maps);

		return result;
	}
}
