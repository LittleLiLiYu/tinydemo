package flow.file.proto;

/**
*this is flow filetest_proto.flow to change,
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

@Service("test_proto_flow")
public class Test_protoFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_protoFlow.class);
	public  Test_protoFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_proto_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_proto_1(Context ct,PriCache pri,PubCache pub){
log.debug("start.....111");//flow->7//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("identity")));//flow->8//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("name")));//flow->9//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("age")));//flow->10//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("address")));//flow->11//

test_proto_10(ct,pri,pub);
 return  ;//flow->12//	}

	private void test_proto_10(Context ct,PriCache pri,PubCache pub){
pri.put("view",toJSON(//flow->18//
"id" , (((JSONObject)pri.get("jsonsObj")).get("identity")),//flow->19//
"name" , (((JSONObject)pri.get("jsonsObj")).get("name")),//flow->20//
"age", (((JSONObject)pri.get("jsonsObj")).get("age")),//flow->21//
"address" , (((JSONObject)pri.get("jsonsObj")).get("address"))//flow->22//
) 
 //flow->18//
  //flow->19//
  //flow->20//
 //flow->21//
  //flow->22//
); //flow->18//
  //flow->19//
  //flow->20//
 //flow->21//
  //flow->22//
 
 //flow->18//
  //flow->19//
  //flow->20//
 //flow->21//
  //flow->22//
//flow->23//
 
	}

	private void test_proto_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
