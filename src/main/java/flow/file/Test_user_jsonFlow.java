package flow.file;

/**
*this is flow filetest_user_json.flow to change,
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

@Service("test_user_json_flow")
public class Test_user_jsonFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_user_jsonFlow.class);
	public  Test_user_jsonFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_user_json_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_user_json_1(Context ct,PriCache pri,PubCache pub){
JSONObject r = toJSON() 
 ;//flow->3//
 r.put("status",toJSONList());  //flow->4//
 (r.getJSONArray("status")).add("1");//flow->5//
 //flow->6//
 log.debug("---"+(r.getJSONArray("status")));//flow->7//
 //flow->8//
 pub.put("userInfo",toJSON(//flow->9//
  "email" , "bdb@123.com",//flow->10//
  "mobile" , "8977949494",//flow->11//
  "user_status" , toJSONList(//flow->12//
    "OPACLA01"//flow->13//
  ) ,//flow->14//
  "appointment_id" , toJSONList(//flow->15//
    "8be690fd-6b4f-41ba-a9c9-403a8a7e0df5"//flow->16//
  ) //flow->17//
 ) 
//flow->9//
    //flow->10//
    //flow->11//
    //flow->12//
    
  //flow->14//
    //flow->15//
    
  //flow->17//
); //flow->9//
    //flow->10//
    //flow->11//
    //flow->12//
    
   //flow->14//
    //flow->15//
    
   //flow->17//
  
//flow->9//
    //flow->10//
    //flow->11//
    //flow->12//
    
  //flow->14//
    //flow->15//
    
  //flow->17//
 //flow->18//
//flow->19//
log.debug("1111"+(((JSONObject)pub.get("userInfo")).getJSONArray("appointment_id")).get(0) );//flow->20//
//flow->21//
  pri.put("view",((JSONObject)pub.get("userInfo"))); //flow->22//
 //flow->23//	}

	private void test_user_json_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
