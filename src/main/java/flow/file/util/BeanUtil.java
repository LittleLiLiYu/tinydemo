package flow.file.util;
import cn.sunline.tiny.core.BeanFactory;
public class BeanUtil{
	public static cn.sunline.tiny.Tools get_tls(){
		return BeanFactory.getBean("Tools");
	}
	public static cn.sunline.tiny.JsDemo get_jd(){
		return BeanFactory.getBean("jsDemo");
	}
}
