package com.spatome.demo.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spatome.demo.factory.DaoFactory;

public abstract class BaseService {

	protected Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

	@Autowired
	protected DaoFactory daoFactory;

	/** 
	 * @Description: 不空检查
	 */
	public void checkNotEmpty(Map<String, String> paramMap){
		for (Map.Entry<String, String> f : paramMap.entrySet()) {
			if(StringUtils.isBlank(f.getValue())){
				throw new RuntimeException(f.getKey()+":null");
			}
		}
	}
}
