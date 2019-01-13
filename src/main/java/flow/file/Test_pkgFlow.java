package flow.file;

/**
*this is flow filetest_pkg.flow to change,
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

@Service("test_pkg_flow")
public class Test_pkgFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_pkgFlow.class);
	public  Test_pkgFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_pkg_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_pkg_1(Context ct,PriCache pri,PubCache pub){
pri.put("mobile","1234567"); //flow->5//
 pri.put("num",100); //flow->6//
//flow->7//	}

	private void test_pkg_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
