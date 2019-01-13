package flow.file;

/**
*this is flow filetest_object.flow to change,
*do not modify by manual,thank you
*/
import org.springframework.stereotype.Service;
import cn.sunline.tiny.web.*;
import cn.sunline.tiny.core.*;
import cn.sunline.tiny.core.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import flow.file.util.*;
import com.alibaba.fastjson.*;
import java.util.*;
import cn.sunline.tiny.core.control.flow.*;

@Service("test_object_flow")
public class Test_objectFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_objectFlow.class);
	public  Test_objectFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_object_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_object_1(Context ct,PriCache pri,PubCache pub){
log.info("info-start...");//flow->7//
log.debug("debug-start..");//flow->8//
//flow->9//
log.debug( "config.data.name:"+cn.sunline.tiny.web.cache.SysConfig.getInstance().getValue("data.name") );//flow->10//
log.debug( "config.debug:"+cn.sunline.tiny.web.cache.SysConfig.getInstance().getValue("debug"));//flow->11//
//flow->12//
//flow->13//
log.debug( "util.md5加密:"+cn.sunline.tiny.web.util.FlowUtil.getInstance().md5("123456"));//flow->14//
log.debug( "util.getNowDate:"+cn.sunline.tiny.web.util.FlowUtil.getInstance().now("yyyyy-MM-dd"));//flow->15//
//flow->16//

test_object_110(ct,pri,pub);
 return  ;//flow->17//	}

	private void test_object_110(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->21//
"msg","展示内置的对象和方法"//flow->22//
,"log.info","log.info(str)"//flow->23//
,"log.debug","log.debug(str)"//flow->24//
,"config","config.getValue(key)"//flow->25//
,"check","check包含常用的验证方法"//flow->26//
,"util","util包含常用的工具类方法"//flow->27//
//flow->28//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_object_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
