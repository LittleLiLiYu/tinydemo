package flow.file;

/**
*this is flow filetest_check.flow to change,
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

@Service("test_check_flow")
public class Test_checkFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_checkFlow.class);
	public  Test_checkFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_check_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_check_1(Context ct,PriCache pri,PubCache pub){
log.info("start...");//flow->3//
//flow->4//
log.debug( "check.isNum:"+cn.sunline.tiny.web.util.Check.getInstance().isNum("100"));//flow->5//
log.debug( "check.isNull:"+cn.sunline.tiny.web.util.Check.getInstance().isNull("h"));//flow->6//
//flow->7//
//flow->8//
pub.put("code",1);//flow->9//
 pub.put("cc","2"); //flow->10//
log.debug(""+((Integer)pub.get("code")));//flow->11//
log.debug(""+pub);//flow->12//
 pub.put("code",null); //flow->13//
//pub.removeParam("code");//flow->14//
log.debug(""+pub);//flow->15//
if(equals(((Integer)pub.get("code")) , null)){//flow->16//
log.debug("111:"+((Integer)pub.get("code")));//flow->17//
//flow->18//
}else{//flow->19//
log.debug("222:"+((Integer)pub.get("code")));//flow->20//
//flow->21//
}//flow->22//
//flow->23//
//flow->24//

test_check_100(ct,pri,pub);
 return  ;//flow->25//	}

	private void test_check_100(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->30//
"msg","展示check对象的使用"//flow->31//
,"check.isNum","是否数字"//flow->32//
,"check.isNull","是否为null"//flow->33//
//flow->34//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_check_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
