package flow.file;

/**
*this is flow filetest_upload.flow to change,
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

@Service("test_upload_flow")
public class Test_uploadFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_uploadFlow.class);
	public  Test_uploadFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_upload_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_upload_1(Context ct,PriCache pri,PubCache pub){
pri.put("uploadPath","E://file/"); //flow->4//

test_upload_2(ct,pri,pub);
 return  ;//flow->5//	}

	private void test_upload_2(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("fileUpload");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("pri.uploadPath","uploadPath",null,"upfilename") );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("2","fileUpload",null,"10","999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
			test_upload_10( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			test_upload_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			test_upload_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			test_upload_999( ct, pri, pub);
			return;
		}
	}

	private void test_upload_10(Context ct,PriCache pri,PubCache pub){
if(equals(((JSONObject)pri.get("upfilename")),null)){//flow->15//

test_upload_999(ct,pri,pub);
 return  ;//flow->16//
}//flow->17//
JSONObject filename = cn.sunline.tiny.core.util.JSON.parse("("+((JSONObject)pri.get("upfilename"))+")");//转成json对象//flow->18//
log.debug(""+filename);//flow->19//
pri.put("filename",filename);//flow->20//

test_upload_100(ct,pri,pub);
 return  ;//flow->21//	}

	private void test_upload_100(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->25//
"fileName", ((JSONObject)pri.get("filename")),//flow->26//
"code","0000",//flow->27//
"msg","success"//flow->28//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void test_upload_999(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON("code","2222","msg","error") 
 
);
		pri.setParam("view",view );
		return ;
	}

}
