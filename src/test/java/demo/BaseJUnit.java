/**   
 * Copyright © 2018 恒朋科技. All rights reserved.
 * 
 * @Title: BaseJUnit.java 
 * @Prject: demo
 * @Package: demo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2018年1月24日 下午5:08:24 
 * @version: V1.0   
 */
package demo;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * @ClassName: BaseJUnit 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2018年1月24日 下午5:08:24  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class BaseJUnit {

}
