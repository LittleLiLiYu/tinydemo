package flow.file;

/**
*this is flow filetrigger_timer.flow to change,
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

@Service("trigger_timer_flow")
public class Trigger_timerFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Trigger_timerFlow.class);
	public  Trigger_timerFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	trigger_timer_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void trigger_timer_1(Context ct,PriCache pri,PubCache pub){
log.info("start timer......");//flow->5//
//flow->6//	}

	private void trigger_timer_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
