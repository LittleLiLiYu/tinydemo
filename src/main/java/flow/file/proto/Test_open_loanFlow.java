package flow.file.proto;

/**
*this is flow filetest_open_loan.flow to change,
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

@Service("test_open_loan_flow")
public class Test_open_loanFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_open_loanFlow.class);
	public  Test_open_loanFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_open_loan_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_open_loan_1(Context ct,PriCache pri,PubCache pub){
log.debug("start.....111");//flow->3//
log.debug("protobuf package:" + ((JSONObject)pri.get("jsonsObj")));//flow->4//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("loanAmt")));//flow->5//

test_open_loan_10(ct,pri,pub);
 return  ;//flow->6//	}

	private void test_open_loan_10(Context ct,PriCache pri,PubCache pub){
pri.put("view",toJSON(//flow->12//
    "transCode", "poc_open_loan_jsons",//flow->13//
    "rcode", "000000",//flow->14//
    "rtime", "2018-03-27 17:39:16",//flow->15//
    "msg", "Successful request",//flow->16//
    "robj", toJSON(//flow->17//
        "cust_no", "910000000218"//flow->18//
    ) 
) 
 //flow->12//
     //flow->13//
     //flow->14//
     //flow->15//
     //flow->16//
     //flow->17//
         
    //flow->19//
//flow->20//
); //flow->12//
     //flow->13//
     //flow->14//
     //flow->15//
     //flow->16//
     //flow->17//
         
     
 
 //flow->12//
     //flow->13//
     //flow->14//
     //flow->15//
     //flow->16//
     //flow->17//
         
    //flow->19//
//flow->20//
 
	}

	private void test_open_loan_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
