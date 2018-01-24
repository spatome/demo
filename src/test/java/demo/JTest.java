/**   
 * Copyright © 2018 恒朋科技. All rights reserved.
 * 
 * @Title: Demo.java 
 * @Prject: demo
 * @Package: demo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2018年1月24日 下午5:11:10 
 * @version: V1.0   
 */
package demo;

import org.junit.Test;

/** 
 * @ClassName: Demo 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2018年1月24日 下午5:11:10  
 */
public class JTest extends BaseJUnit {

	@Test
	public void test(){
		System.out.println("This is Test!");
	}

/*	@Autowired
	private DemoService demoServiceImpl;
	
	@Test
	public void testService(){
		demoServiceImpl.test("zw");
	}*/
}
