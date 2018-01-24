/**   
 * Copyright © 2017 ****. All rights reserved.
 * 
 * @Title: DemoServiceImpl.java 
 * @Prject: demo
 * @Package: com.spatome.demo.service.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月22日 下午4:18:57 
 * @version: V1.0   
 */
package com.spatome.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.service.DemoService;

/** 
 * @ClassName: DemoServiceImpl 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月22日 下午4:18:57  
 */
@Transactional
@Service
public class DemoServiceImpl extends BaseService implements DemoService {

	@Override
	public void test(String name) {
		System.out.println("hello:"+name);
	}
}
