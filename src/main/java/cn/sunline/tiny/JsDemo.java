package cn.sunline.tiny;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
@Component("jsDemo")
public class JsDemo   {

	private static final Logger LOG = LoggerFactory.getLogger(JsDemo.class);

	

	public String get() {
		return "hello demo";
	}

	public String get2() {
		return "hello demo2";
	}
	
	private static Map<String,Object> map = new HashMap<String,Object>();
	public String testMem() {
		String uuid  = UUID.randomUUID().toString().replace("-", "");  
		
		String s= "";
		for(int i=0;i<1000;i++) {
			s+=UUID.randomUUID().toString();
		}
		map.put(uuid,s);
		System.out.print(map.size());
		return uuid;
	}

	@SuppressWarnings("restriction")
	public String getJsonsStr(Object o) {
		
		if(o == null) {
			return "{}";
		}
		
		StringBuffer str = new StringBuffer();
		
		if( ! (o instanceof ScriptObjectMirror)) {
			return o.toString();
		}
		
		ScriptObjectMirror s = (ScriptObjectMirror) o;
		one2(str,s);
		//System.out.println(o.getClass().getName());
		str.delete(str.length()-1, str.length());
		
		return str.toString();
	}
	
	
	@SuppressWarnings("restriction")
	private void one1(StringBuffer str,String key,Object value) {
		str.append("\""+key+"\":");
		if( ! (value instanceof ScriptObjectMirror)) {
			if(value!=null) {
				str.append("\""+value.toString()+"\",");
			}else {
				str.append("\"\",");
			}
			
		}else {
			//System.out.println("one1:"+value.getClass().getName());
			ScriptObjectMirror s = (ScriptObjectMirror)value;
			
			if(s.isArray()) {
				Collection<Object> list = s.values();
				str.append("[");
				for(Object lo : list) {
					one2(str,lo);
				}
				str.delete(str.length()-1, str.length());
				str.append("],");
			}else {
				str.append("{");
				for (String _key : s.keySet()) {
					Object _value = s.get(_key);
					one1(str,_key,_value);
				}
				str.delete(str.length()-1, str.length());
				str.append("},");
			}
		}
	}
	
	@SuppressWarnings("restriction")
	private void one2(StringBuffer str,Object value) {
		if( ! (value instanceof ScriptObjectMirror)) {
			str.append("\""+value.toString()+"\",");
		}else {
			//System.out.println("one2:"+value.getClass().getName());
			ScriptObjectMirror s = (ScriptObjectMirror)value;
			if(s.isArray()) {
				Collection<Object> list = s.values();
				str.append("[");
				for(Object lo : list) {
					one2(str,lo);
				}
				str.delete(str.length()-1, str.length());
				str.append("],");
			}else {
				str.append("{");
				for (String _key : s.keySet()) {
					Object _value = s.get(_key);
					one1(str,_key,_value);
				}
				str.delete(str.length()-1, str.length());
				str.append("},");
			}
		}
	}
}
