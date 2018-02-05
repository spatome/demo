/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: HttpUtil.java 
 * @Prject: zjd
 * @Package: com.hengpeng.util 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年11月13日 下午2:07:29 
 * @version: V1.0   
 */
package com.spatome.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: HttpUtil 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年11月13日 下午2:07:29  
 */
public class HttpUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);
    
    private final static CloseableHttpClient CLIENT = HttpClients.createDefault();

    public static String post(String URL, String transType, String xmlData) {
    	LOGGER.info("=============center============>>");
    	LOGGER.info(xmlData);

    	HttpPost post = new HttpPost(URL);
    	CloseableHttpResponse response = null;
        try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();  
			params.add(new BasicNameValuePair("transType", transType));  
			params.add(new BasicNameValuePair("transMessage", xmlData));
			post.setEntity(new UrlEncodedFormEntity(params, "GBK"));

			post.setHeader("Content-type", "application/x-www-form-urlencoded");
			post.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			response = CLIENT.execute(post);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String content = EntityUtils.toString(entity, "UTF-8");
				LOGGER.info("<<=============center============");
			    LOGGER.info(content);
//			    return getParameter(content, XML_KEY);
			    return "";
			}else{
				LOGGER.error("<<=============center============");
				LOGGER.error("Response httpEntity is null");
				throw new RuntimeException("Http post异常：没有回应数据");
			}
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("编码处理异常："+e);
			throw new RuntimeException("编码处理异常:"+e.getMessage());
		} catch (ClientProtocolException e) {
			LOGGER.error("协议处理异常："+e);
			throw new RuntimeException("协议处理异常:"+e.getMessage());
		} catch (ParseException e) {
			LOGGER.error("数据格式处理异常："+e);
			throw new RuntimeException("数据格式处理异常:"+e.getMessage());
		} catch (IOException e) {
			LOGGER.error("IO异常："+e);
			throw new RuntimeException("IO异常:"+e.getMessage());
		}finally {
			if(response!=null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
				}
			}
			if(post !=null)	post.abort();
		}
    };

	public static Map<String, String> toMap(HttpServletRequest request) throws Exception{
		Map<String, String> result = new HashMap<String, String>();

		Enumeration<?> enu = request.getParameterNames();
		while(enu.hasMoreElements()){
			String key = (String)enu.nextElement();
			result.put(key, request.getParameter(key));
		}

		return result;
	}
}
