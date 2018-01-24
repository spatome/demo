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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.spatome.demo.controller.BaseController.BaseVO;
import com.spatome.demo.service.TranService;
import com.spatome.demo.service.impl.BaseService;
import com.spatome.demo.vo.UserVO;

/** 
 * @ClassName: Tran10000ServiceImpl 
 * @Description: 查询菜单
 * @author: zhangwei
 * @date: 2017年9月27日 下午6:44:45  
 */
@Service
public class Tran00000ServiceImpl extends BaseService implements TranService {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) {
		BaseVO<UserVO> result = new BaseVO<UserVO>();

		return result;
	}
}
