/**   
 * Copyright © 2017 ****. All rights reserved.
 * 
 * @Title: CollectionUtil.java 
 * @Prject: demo
 * @Package: com.spatome.util 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年9月18日 下午6:24:53 
 * @version: V1.0   
 */
package com.spatome.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.spatome.demo.common.exception.SException;

/** 
 * @ClassName: CollectionUtil 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年9月18日 下午6:24:53  
 */
public class CollectionUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(CollectionUtil.class);

	/** 
	 * @Description: 分隔List
	 * @param list
	 * @param len
	 * @return
	 * @return: List<List<T>>
	 */
	public static <T> List<List<T>> splitList(List<T> list, int len) {
		if (list == null || list.size() == 0 || len < 1) {
			return null;
		}

		List<List<T>> result = new ArrayList<List<T>>();

		int size = list.size();
		int count = (size + len - 1) / len;

		for (int i = 0; i < count; i++) {
			List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
			result.add(subList);
		}
		return result;
	}

	/** 
	 * @Description: List<Bean>按照bean属性排序
	 * @param list
	 * @param property
	 * @param asc
	 * @return: void
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> void sort(List<T> list, String property, boolean asc) {
        Comparator<?> comparator = ComparableComparator.getInstance();
        comparator = ComparatorUtils.nullLowComparator(comparator);
        if (!asc) {
            comparator = ComparatorUtils.reversedComparator(comparator);
        }
        Collections.sort(list, new BeanComparator(property, comparator));
    }

    /** 
     * @Description: List<bean>按照属性分组
     */
    public static <K, T> boolean listGroup2Map(List<T> list, Map<K, List<T>> map, String methodName, Class<T> clazz) {
    	try {
			Method method = clazz.getDeclaredMethod(methodName);

			List<T> listTmp = null;
			for (T t : list) {
				@SuppressWarnings("unchecked")
				K key = (K)method.invoke(t);
				listTmp = map.get(key);
				if(listTmp==null){
					listTmp = new ArrayList<T>();
					map.put(key, listTmp);
				}
				listTmp.add(t);
			}

			return true;
		} catch (Exception e) {
			return false;
		}
    }

	/**
	 * @Description: Bean转Map
	 * 去除value是null的
	 */
	public static <T> Map<String, String> beanToMap(T bean) {
		Map<String, String> map = Maps.newHashMap();
		if (bean != null) {
			BeanMap beanMap = BeanMap.create(bean);
			for (Object key : beanMap.keySet()) {
				if(beanMap.get(key)!=null){
					map.put(key + "", beanMap.get(key)+"");	
				}
			}
		}

		return map;
	}

    /** 
     * @Description: JSON字符串转MAP<String, String>
     * 如果Map结构复杂，JSON转BEAN更方便
     */
    @SuppressWarnings("unchecked")
	public static Map<String, String> toMap(String data) throws SException {
    	Map<String, String> result = new HashMap<String, String>();

    	try {
			if(StringUtils.isBlank(data)){
			}else{
				ObjectMapper om = new ObjectMapper();
				result = om.readValue(data, Map.class);
			}
		} catch (Exception e) {
			LOGGER.error("toMap", e);
			throw new SException("9999", "JSON String 转Map失败:"+e.getMessage());
		}

    	return result;
    }

    /** 
     * @Description: Map转String
     * @param map
     * @param div
     * @return
     * @return: String
     */
    public static <T> String toString(Map<String, T> map, String div){
    	if(map==null){
    		return "";
    	}

    	StringBuilder sb = new StringBuilder();
    	for (Map.Entry<String, T> f : map.entrySet()) {
			sb.append(f.getKey()).append("{").append(f.getValue()).append("}").append(div);
		}

    	return sb.toString();
    }
    
	/** 
	 * @Description: 测试打印List
	 * @param resultList
	 * @return: void
	 */
	public static void ps(List<?> resultList){
		System.out.println("******************开始打印数据*****************");
		if(resultList!=null){
			System.out.println("当前记录条数为："+resultList.size());
			for(Object result : resultList){
				System.out.println(result);
			}
		}
		System.out.println("*****************打印结束****************");
	};

	
	public static void main(String[] args) {
	}
}