package flow.file;

/**
*this is flow filetest_bigjson.flow to change,
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

@Service("test_bigjson_flow")
public class Test_bigjsonFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_bigjsonFlow.class);
	public  Test_bigjsonFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_bigjson_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_bigjson_1(Context ct,PriCache pri,PubCache pub){
String content = cn.sunline.tiny.web.util.FlowUtil.getInstance().getFileContent("/opt/dir/big.json");//flow->3//
 JSONObject big = cn.sunline.tiny.core.util.JSON.parse(content);//flow->4//
 //var big = {"a":"11","b":[{"c":1},{"c":2}],"d":{"e":1}}; //flow->5//
//var big = {"a":"11","b":123};//flow->6//
 //log.debug( JSON.stringify(big) );	//flow->7//
 //pri.view = JSON.stringify(big); var s = jd.getJsonsStr(big);//flow->8//
  pri.put("view",big); //flow->9//
 //flow->10//	}

	private void test_bigjson_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
