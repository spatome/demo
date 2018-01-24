package com.spatome.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/** 
 * @ClassName: XStreamUtil 
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月28日 下午4:52:07  
 */
public class XStreamUtil {
	private final static String XML_HEAD = "<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n";

	private final static XStream XM = new XStream(new DomDriver("GBK"));

	static{
		XM.aliasSystemAttribute(null, "class");
		XM.autodetectAnnotations(true);
	}
	
	public static String toXml(Object object){
		return XML_HEAD + XM.toXML(object);
	};
	
	@SuppressWarnings("unchecked")
	public static <T> T toBean(String xml, Class<T> clazz){
		XStream xStream = new XStream(new DomDriver("GBK"));
		xStream.processAnnotations(clazz);

		return (T)xStream.fromXML(xml);
	}
}
