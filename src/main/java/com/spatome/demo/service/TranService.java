/**   
 * Copyright © 2017 ****. All rights reserved.
 * 
 * @Title: CmdService.java 
 * @Prject: lianwa
 * @Package: com.hengpeng.lianwa.service 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年9月27日 下午2:42:48 
 * @version: V1.0   
 */
package com.spatome.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @ClassName: TranService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年9月27日 下午2:42:48  
 */
public interface TranService {

	public Object execute(HttpServletRequest request, HttpServletResponse response);
	
}
