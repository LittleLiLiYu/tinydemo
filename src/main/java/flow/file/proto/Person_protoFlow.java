package flow.file.proto;

/**
*this is flow fileperson_proto.flow to change,
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

@Service("person_proto_flow")
public class Person_protoFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Person_protoFlow.class);
	public  Person_protoFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	person_proto_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void person_proto_1(Context ct,PriCache pri,PubCache pub){
log.debug("start.....111");//flow->6//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("identity")));//flow->7//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("name")));//flow->8//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("age")));//flow->9//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("address")));//flow->10//
log.debug("protobuf package:" + ((((JSONObject)pri.get("jsonsObj")).getJSONObject("head")).get("filename")));//flow->11//

person_proto_10(ct,pri,pub);
 return  ;//flow->12//	}

	private void person_proto_10(Context ct,PriCache pri,PubCache pub){

person_proto_100(ct,pri,pub);
 return  ;//flow->19//	}

	private void person_proto_100(Context ct,PriCache pri,PubCache pub){
pri.put("view",toJSON(//flow->24//
"status" , "000",//flow->25//
"msg" , "success"//flow->26//
) 
 //flow->24//
  //flow->25//
); //flow->24//
  //flow->25//
  
 
 //flow->24//
  //flow->25//
  
//flow->27//
//flow->28//
//flow->29//
 
	}

	private void person_proto_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
