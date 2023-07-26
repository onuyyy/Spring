package com.sist.main;

import javax.xml.parsers.*;

import java.io.File;
import java.util.*;
public class ClassPathMapApplicationContext implements ApplicationContext {

	private Map clsMap=new HashMap();
	
	public ClassPathMapApplicationContext(String path) {
		
		try {
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser();
			XMLParse xm=new XMLParse();
			sp.parse(new File(path), xm);
			clsMap=xm.getMap();
			
		} catch(Exception ex) {}
	}
	
	@Override
	public Object getBean(String key) {
		return clsMap.get(key);
	}
	

}
