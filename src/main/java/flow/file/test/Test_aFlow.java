package flow.file.test;

/**
*this is flow filetest_a.flow to change,
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

@Service("test_a_flow")
public class Test_aFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_aFlow.class);
	public  Test_aFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_a_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_a_1(Context ct,PriCache pri,PubCache pub){
log.debug("pri:"+pri);//flow->3//
log.debug("pub:"+pub);//flow->4//
//flow->5//
//flow->6//

test_a_secrchUser(ct,pri,pub);
 return  ;//flow->7//	}

	private void test_a_secrchUser(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->11//
            "code","111"//flow->12//
        ) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_a_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
