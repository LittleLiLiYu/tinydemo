package flow.file;

/**
*this is flow fileindex.flow to change,
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

@Service("index_flow")
public class IndexFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(IndexFlow.class);
	public  IndexFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	index_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void index_1(Context ct,PriCache pri,PubCache pub){
log.info("start...12345"); //flow->3//
log.info("start...11111"); //flow->4//
log.info("start...22222"); //flow->5//
 pri.put("jsonsObj",toJSON("data",toJSON() 
));  
 
  //flow->6//
JSONObject data = ((JSONObject)pri.get("jsonsObj")); //flow->7//
 data.put("num",1);  //flow->8//
Integer num = ((int)data.get("num")); //flow->9//
if(equals( num , 1)){ //flow->10//
 //flow->11//
} //flow->12//

index_100(ct,pri,pub);
 return  ; //flow->13//
 
	}

	private void index_100(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("templateView");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("index",null,null,null) );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("100","templateView",null,null,"999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			index_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			index_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			index_999( ct, pri, pub);
			return;
		}
	}

	private void index_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
