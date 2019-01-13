package flow.file;

/**
*this is flow filetest_pub.flow to change,
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

@Service("test_pub_flow")
public class Test_pubFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_pubFlow.class);
	public  Test_pubFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_pub_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
else 		if(flowsn.equals("1000")){
 		 try{
 		 	test_pub_1000(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_pub_1(Context ct,PriCache pri,PubCache pub){
pri.put("mobile","1234567"); //flow->5//
 pri.put("num",100); //flow->6//

test_pub_10(ct,pri,pub);
 return  ;//flow->7//	}

	private void test_pub_10(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("pubSet");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("pri.mobile","mobile",null,null) );
	ps.add(new FlowPara("pri.num","page.num1",null,null) );
	ps.add(new FlowPara("pri.num","page.num2",null,null) );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("10","pubSet",null,"15","999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
			test_pub_15( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			test_pub_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			test_pub_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			test_pub_999( ct, pri, pub);
			return;
		}
	}

	private void test_pub_15(Context ct,PriCache pri,PubCache pub){
log.debug("set:"+pub);//flow->17//

test_pub_20(ct,pri,pub);
 return  ;//flow->18//	}

	private void test_pub_20(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("pubClear");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("null","mobile",null,null) );
	ps.add(new FlowPara("null","page.num1",null,null) );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("20","pubClear",null,"30","999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
			test_pub_30( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			test_pub_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			test_pub_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			test_pub_999( ct, pri, pub);
			return;
		}
	}

	private void test_pub_30(Context ct,PriCache pri,PubCache pub){
log.debug("clear:"+pub);//flow->27//

test_pub_110(ct,pri,pub);
 return  ;//flow->28//	}

	private void test_pub_110(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->32//
"msg","展示pubClear和pubSet组件"//flow->33//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_pub_1000(Context ct,PriCache pri,PubCache pub){

test_pub_10(ct,pri,pub);
 return  ;//flow->41//	}

	private void test_pub_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
