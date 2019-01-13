package flow.file;

/**
*this is flow filetest_login.flow to change,
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

@Service("test_login_flow")
public class Test_loginFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_loginFlow.class);
	public  Test_loginFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_login_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_login_1(Context ct,PriCache pri,PubCache pub){
if( cn.sunline.tiny.web.util.Check.getInstance().isNull((pri.getParam("name"))) ){//flow->7//
pri.put("msg","用户名不可为空");//flow->8//
pri.put("code","4000");//flow->9//

test_login_998(ct,pri,pub);
 return  ;//flow->10//
}//flow->11//
//flow->12//
//查询数据库,判断用户名和密码是否正确//flow->13//
//flow->14//
//如果成功,切记//flow->15//
 pri.put("adminId",10); //flow->16//
ct.loginSuccess(((Integer)pri.get("adminId")));//flow->17//
pub.put("userId",1);//flow->18//
//flow->19//

test_login_10(ct,pri,pub);
 return  ;//flow->20//
//flow->21//	}

	private void test_login_10(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->25//
"code","00001",//flow->26//
"msg","登录成功"//flow->27//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_login_998(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->33//
"code",(pri.get("code")),//flow->34//
"msg",(pri.get("msg"))//flow->35//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_login_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
