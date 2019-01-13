package flow.file;

/**
*this is flow filelogout.flow to change,
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

@Service("logout_flow")
public class LogoutFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(LogoutFlow.class);
	public  LogoutFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	logout_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void logout_1(Context ct,PriCache pri,PubCache pub){
ct.getRequest().getSession().invalidate();//flow->4//
log.info("start...22222");//flow->5//	}

	private void logout_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
