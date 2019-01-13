package flow.file;

/**
*this is flow filemorelogin.flow to change,
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

@Service("morelogin_flow")
public class MoreloginFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(MoreloginFlow.class);
	public  MoreloginFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	morelogin_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void morelogin_1(Context ct,PriCache pri,PubCache pub){
log.info("start...");//flow->3//
log.info("start...22222");//flow->4//

morelogin_100(ct,pri,pub);
 return  ;//flow->5//	}

	private void morelogin_100(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->9//
"code",0000,//flow->10//
"msg","测试用户重复登录"//flow->11//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void morelogin_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
