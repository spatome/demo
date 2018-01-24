package com.spatome.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spatome.demo.factory.DaoFactory;

public abstract class BaseService {

	protected Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

	@Autowired
	protected DaoFactory daoFactory;
}
