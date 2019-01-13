package flow.file.proto;

/**
*this is flow filelogin_proto.flow to change,
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

@Service("login_proto_flow")
public class Login_protoFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Login_protoFlow.class);
	public  Login_protoFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	login_proto_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void login_proto_1(Context ct,PriCache pri,PubCache pub){
log.debug("start.....111");//flow->3//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("name")));//flow->4//
log.debug("protobuf package:" + (((JSONObject)pri.get("jsonsObj")).get("age")));//flow->5//

login_proto_10(ct,pri,pub);
 return  ;//flow->6//	}

	private void login_proto_10(Context ct,PriCache pri,PubCache pub){
pri.put("view",toJSON(//flow->11//
"status" , "0000",//flow->12//
"msg","succ"//flow->13//
) 
 //flow->11//
  //flow->12//
); //flow->11//
  //flow->12//

 
 //flow->11//
  //flow->12//

//flow->14//
 
	}

	private void login_proto_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
