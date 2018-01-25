/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: ImgVO.java 
 * @Prject: qmdlb-man
 * @Package: com.hengpeng.qmdlb.vo 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年11月2日 下午3:10:47 
 * @version: V1.0   
 */
package com.spatome.demo.vo;

import java.io.Serializable;

/**
 * @ClassName: ImgVO
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年11月2日 下午3:10:47
 */
public class ImgVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String imageName;
	private String imageUrl;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
