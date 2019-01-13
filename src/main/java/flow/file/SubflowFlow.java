package flow.file;

/**
*this is flow filesubflow.flow to change,
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

@Service("subflow_flow")
public class SubflowFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(SubflowFlow.class);
	public  SubflowFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	subflow_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void subflow_1(Context ct,PriCache pri,PubCache pub){
pri.put("c",2);//flow->3//

subflow_2(ct,pri,pub);
 return  ;//flow->4//	}

	private void subflow_2(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("subflow");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("null","flow2",null,null) );
	ps.add(new FlowPara("null",null,null,null) );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("2","subflow",null,"3","999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
			subflow_3( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			subflow_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			subflow_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			subflow_999( ct, pri, pub);
			return;
		}
	}

	private void subflow_3(Context ct,PriCache pri,PubCache pub){
pri.put("b",(pri.get("a"))); //flow->13//	}

	private void subflow_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
