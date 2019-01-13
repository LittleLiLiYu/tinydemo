package flow.file;

/**
*this is flow filetiny_config.flow to change,
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

@Service("tiny_config_flow")
public class Tiny_configFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Tiny_configFlow.class);
	public  Tiny_configFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	tiny_config_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void tiny_config_1(Context ct,PriCache pri,PubCache pub){
log.info("start...");//flow->3//

tiny_config_100(ct,pri,pub);
 return  ;//flow->4//	}

	private void tiny_config_100(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->9//
"name",cn.sunline.tiny.web.cache.SysConfig.getInstance().getValue("data.name"),//flow->10//
"name2",cn.sunline.tiny.web.cache.SysConfig.getInstance().getValue("data.name2")//flow->11//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void tiny_config_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
