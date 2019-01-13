package flow.file;

/**
*this is flow filesql_jsons.flow to change,
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

@Service("sql_jsons_flow")
public class Sql_jsonsFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Sql_jsonsFlow.class);
	public  Sql_jsonsFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	sql_jsons_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
else 		if(flowsn.equals("100")){
 		 try{
 		 	sql_jsons_100(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void sql_jsons_1(Context ct,PriCache pri,PubCache pub){
pri.put("name","yyy");//flow->4//
pri.put("age","100");//flow->5//
pri.put("sex","M");//flow->6//
 pri.put("address","aaa");  //flow->7//
//flow->8//
//保存单据//flow->9//
flow.file.model.User user = new flow.file.model.User();//flow->10//
user.name=(pri.getParam("name"));//flow->11//
user.age=Long.parseLong((pri.getParam("age")));//flow->12//
user.sex=(pri.getParam("sex"));//flow->13//
user.address=(pri.getParam("address"));//flow->14//
//flow->15//
user.save();//flow->16//
JSONObject robj= toJSON() 
;//flow->17//
 robj.put("order_id","CMB"); //flow->18//
//flow->19//
//flow->20//

sql_jsons_100(ct,pri,pub);
 return  ;//flow->21//
 
	}

	private void sql_jsons_100(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->24//
 "rcode","999999",//flow->25//
 "msg",1,//flow->26//
 "rtime",1//flow->27//
 ) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void sql_jsons_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
