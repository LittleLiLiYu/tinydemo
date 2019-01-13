package flow.file;

/**
*this is flow filetest_uba.flow to change,
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

@Service("test_uba_flow")
public class Test_ubaFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_ubaFlow.class);
	public  Test_ubaFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_uba_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_uba_1(Context ct,PriCache pri,PubCache pub){
log.info("start...");//flow->3//
 pri.put("usercd","1"); //flow->4//

test_uba_100(ct,pri,pub);
 return  ;//flow->5//	}

	private void test_uba_100(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("uba");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("1","test",null,null) );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("100","uba",null,"101","999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
			test_uba_101( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			test_uba_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			test_uba_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			test_uba_999( ct, pri, pub);
			return;
		}
	}

	private void test_uba_101(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->13//
"code","000",//flow->14//
"list",toJSONList(//flow->15//
toJSON(//flow->16//
"rcode",0//flow->17//
) 
) ,//flow->19//
"msg","测试行为分析sdk收集"//flow->20//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_uba_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
