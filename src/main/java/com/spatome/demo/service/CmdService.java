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

import java.util.Map;

/** 
 * @ClassName: TranService 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年9月27日 下午2:42:48  
 */
public interface CmdService {

	public Object execute(Map<String, String> maps);
	
}
