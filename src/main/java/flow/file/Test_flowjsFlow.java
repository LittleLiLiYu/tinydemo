package flow.file;

/**
*this is flow filetest_flowjs.flow to change,
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

@Service("test_flowjs_flow")
public class Test_flowjsFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_flowjsFlow.class);
	public  Test_flowjsFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_flowjs_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_flowjs_1(Context ct,PriCache pri,PubCache pub){
log.info("start...");//flow->3//

test_flowjs_110(ct,pri,pub);
 return  ;//flow->4//	}

	private void test_flowjs_110(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->8//
"get",BeanUtil.get_jd().get(),//flow->9//
"get2",BeanUtil.get_jd().get2(),//flow->10//
"msg","展示自定义flowjs的使用23"//flow->11//
//flow->12//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_flowjs_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
