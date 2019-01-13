package flow.file;

/**
*this is flow filetest_json_log4j.flow to change,
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

@Service("test_json_log4j_flow")
public class Test_json_log4jFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_json_log4jFlow.class);
	public  Test_json_log4jFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_json_log4j_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_json_log4j_1(Context ct,PriCache pri,PubCache pub){
log.debug("start...");//flow->3//
     pri.put("j",toJSONList(//flow->4//
    toJSON(//flow->5//
        "password","123456"//flow->6//
    ) 
)  //flow->4//
    //flow->5//
        
    //flow->7//
); //flow->4//
    //flow->5//
        
     
  //flow->4//
    //flow->5//
        
    //flow->7//
//flow->8//
log.debug( "jsons:"+cn.sunline.tiny.core.util.JSON.stringify(((JSONArray)pri.get("j"))) );//flow->9//

test_json_log4j_10(ct,pri,pub);
 return  ;//flow->10//
 
	}

	private void test_json_log4j_10(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->14//
"code","00001",//flow->15//
"msg","log4j日志json格式化"//flow->16//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_json_log4j_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
