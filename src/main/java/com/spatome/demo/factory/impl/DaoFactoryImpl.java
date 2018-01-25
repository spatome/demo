/**   
 * Copyright © 2017 ****. All rights reserved.
 * 
 * @Title: DaoFactoryImpl.java 
 * @Prject: demo
 * @Package: com.spatome.demo.factory.impl 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月22日 下午4:09:09 
 * @version: V1.0
 */
package com.spatome.demo.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.dao.TestMapper;
import com.spatome.demo.factory.DaoFactory;

/** 
 * @ClassName: DaoFactoryImpl 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年8月22日 下午4:09:09  
 */
@Lazy
@Service
public class DaoFactoryImpl implements DaoFactory {

	@Autowired
	private TestMapper testMapper;
	
	@Override
	public TestMapper getTestMapper() {
		return testMapper;
	}

}
