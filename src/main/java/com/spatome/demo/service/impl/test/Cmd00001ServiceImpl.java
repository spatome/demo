/**   
 * Copyright © 2017 ****. All rights reserved.
 * 
 * @Title: Tran10000ServiceImpl.java 
 * @Prject: demo
 * @Package: com.spatome.demo.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月22日 下午4:18:57 
 * @version: V1.0   
 */
package com.spatome.demo.service.impl.test;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.spatome.demo.common.exception.SException;
import com.spatome.demo.controller.BaseController.BaseVO;
import com.spatome.demo.service.CmdService;
import com.spatome.demo.service.impl.BaseService;
import com.spatome.util.secure.JwtUtil;

/** 
 * @ClassName: Cmd00001ServiceImpl 
 * @Description: jwt测试
 * @author: zhangwei
 * @date: 2017年9月27日 下午6:44:45  
 */
@Service
public class Cmd00001ServiceImpl extends BaseService implements CmdService {

	@Override
	public Object execute(Map<String, String> maps) {
		BaseVO<String> result = new BaseVO<String>();

		try {
			String param1 = maps.get("param1");

			String token = JwtUtil.sign(new JwtUtil.TokenInfo(param1, "admin"), 0);
			
			JwtUtil.TokenInfo tokenInfo = JwtUtil.unSign(token);
			System.out.println(tokenInfo.getUserNo());
			System.out.println(tokenInfo.getRoleNo());

			result.setBody(token);
		} catch (Exception e) {
			throw new SException("9999", "jwt异常");
		}
		
		return result;
	}
}
