package flow.file;

/**
*this is flow filetest_comp.flow to change,
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

@Service("test_comp_flow")
public class Test_compFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_compFlow.class);
	public  Test_compFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_comp_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_comp_1(Context ct,PriCache pri,PubCache pub){
log.info("start...");//flow->3//

test_comp_100(ct,pri,pub);
 return  ;//flow->4//	}

	private void test_comp_100(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("comp_demo");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("conf.debug","param1",null,null) );
	ps.add(new FlowPara("test...","param2",null,null) );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("100","comp_demo",null,"110","999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
			test_comp_110( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			test_comp_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			test_comp_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			test_comp_999( ct, pri, pub);
			return;
		}
	}

	private void test_comp_110(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->14//
"code","000",//flow->15//
"msg","展示自定义组件的使用"//flow->16//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_comp_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
