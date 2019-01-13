package flow.file.test;

/**
*this is flow filetest_bigdecimal.flow to change,
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

@Service("test_bigdecimal_flow")
public class Test_bigdecimalFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_bigdecimalFlow.class);
	public  Test_bigdecimalFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_bigdecimal_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_bigdecimal_1(Context ct,PriCache pri,PubCache pub){
pri.put("temp_amount",new java.math.BigDecimal("1.34")); //flow->4//
 JSONObject inputJson = toJSON(//flow->5//
 "transRef","",//flow->6//
 "amount",((java.math.BigDecimal)pri.get("temp_amount"))//flow->7//
 ) 
 //flow->5//
 //flow->6//
 //flow->7//
 ;//flow->8//
 //flow->9//
  pri.put("view",inputJson); //flow->10//
 
	}

	private void test_bigdecimal_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
