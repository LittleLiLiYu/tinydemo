package flow.file;

/**
*this is flow filetest_sign.flow to change,
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

@Service("test_sign_flow")
public class Test_signFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_signFlow.class);
	public  Test_signFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_sign_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_sign_1(Context ct,PriCache pri,PubCache pub){
log.info("start...");//flow->3//
//flow->4//
log.debug(""+(pub.get("random")));//flow->5//

test_sign_100(ct,pri,pub);
 return  ;//flow->6//	}

	private void test_sign_100(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->10//
"code","000",//flow->11//
"msg","展示防篡改"//flow->12//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_sign_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
