package flow.file;

/**
*this is flow filetiny_image.flow to change,
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

@Service("tiny_image_flow")
public class Tiny_imageFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Tiny_imageFlow.class);
	public  Tiny_imageFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	tiny_image_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void tiny_image_1(Context ct,PriCache pri,PubCache pub){
log.debug("图片展示...");//flow->3//
//flow->4//
 pri.put("path",cn.sunline.tiny.web.cache.SysConfig.getInstance().getValue("local_path")+"/images/ke.png"); //flow->5//

tiny_image_10(ct,pri,pub);
 return  ;//flow->6//	}

	private void tiny_image_10(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("imageShow");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("pri.path","path",null,null) );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("10","imageShow",null,null,"999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			tiny_image_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			tiny_image_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			tiny_image_999( ct, pri, pub);
			return;
		}
	}

	private void tiny_image_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
