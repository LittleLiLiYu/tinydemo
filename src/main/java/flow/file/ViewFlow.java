package flow.file;

/**
*this is flow fileview.flow to change,
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

@Service("view_flow")
public class ViewFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(ViewFlow.class);
	public  ViewFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("redirect")){
 		 try{
 		 	view_redirect(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
else 		if(flowsn.equals("1")){
 		 try{
 		 	view_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
else 		if(flowsn.equals("100")){
 		 try{
 		 	view_100(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
else 		if(flowsn.equals("1100")){
 		 try{
 		 	view_1100(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
else 		if(flowsn.equals("1000")){
 		 try{
 		 	view_1000(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
else 		if(flowsn.equals("list")){
 		 try{
 		 	view_list(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
else 		if(flowsn.equals("redirect_3")){
 		 try{
 		 	view_redirect_3(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void view_1(Context ct,PriCache pri,PubCache pub){
pri.put("a","1234");//flow->6//
log.info("start...."+(pri.get("a")));//flow->7//

view_10(ct,pri,pub);
 return  ;//flow->8//	}

	private void view_10(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->12//
"code","000"+(pri.get("a")),//flow->13//
"msg","成功"//flow->14//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void view_redirect(Context ct,PriCache pri,PubCache pub){
log.info("start...");//flow->19//

view_redirect_2(ct,pri,pub);
 return  ;//flow->20//	}

	private void view_redirect_2(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("view");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("redirect:view.tml?flow=redirect_3",null,null,null) );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("redirect_2","view",null,null,"999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			view_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			view_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			view_999( ct, pri, pub);
			return;
		}
	}

	private void view_redirect_3(Context ct,PriCache pri,PubCache pub){
String view = cn.sunline.tiny.core.util.JSON.stringify(toJSON(//flow->28//
"code","0000",//flow->29//
"msg","我是重定向过来的"//flow->30//
) 
 
);
		pri.setParam("view",view );
		return ;
	}

	private void view_list(Context ct,PriCache pri,PubCache pub){
log.info("start...");//flow->36//
pri.put("list",toJSONList(//flow->37//
toJSON("index",1,"name","java") 
,//flow->38//
toJSON("index",2,"name","cpp") 
,//flow->39//
toJSON("index",3,"name","python") 
,//flow->40//
toJSON("index",4,"name","go") 
) //flow->37//
//flow->38//
//flow->39//
//flow->40//
//flow->41//
); //flow->37//
 
//flow->38//
 
//flow->39//
 
//flow->40//
 
 //flow->37//
//flow->38//
//flow->39//
//flow->40//
//flow->41//
//flow->42//

view_list_2(ct,pri,pub);
 return  ;//flow->43//
 
	}

	private void view_list_2(Context ct,PriCache pri,PubCache pub){
JSONObject jsons = toJSON() 
 ;//flow->47//
    jsons.put("rows",toJSONList());  //flow->48//
    for(int iiii=0;iiii<((JSONArray)pri.get("list")).size();iiii++){
JSONObject o=(JSONObject)((JSONArray)pri.get("list")).get(iiii);   //flow->49//
    (jsons.getJSONArray("rows")).add(o);//flow->50//
};  //flow->51//

pri.setParam("view",jsons);
	}

	private void view_100(Context ct,PriCache pri,PubCache pub){
pri.put("view","pri.view=?"); //flow->57//	}

	private void view_1000(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("view");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("view",null,null,null) );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("1000","view",null,null,"999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			view_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			view_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			view_999( ct, pri, pub);
			return;
		}
	}

	private void view_1100(Context ct,PriCache pri,PubCache pub){
	cn.sunline.tiny.core.control.component.Base ctl = BeanFactory.getBean("view");
	List<FlowPara> ps = new ArrayList<FlowPara>();
	ps.add(new FlowPara("upload",null,null,null) );
	cn.sunline.tiny.core.control.flow.FlowInfo flowInfo = new cn.sunline.tiny.core.control.flow.FlowInfo("1100","view",null,null,"999","999",ps);
		int i = ctl.doControl(ct,flowInfo);
		if(i == cn.sunline.tiny.core.control.component.Basecomponent.SUCCESS){
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.ERROR){
			view_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.FAIL){
			view_999( ct, pri, pub);
			return;
		}else if(i == cn.sunline.tiny.core.control.component.Basecomponent.OVER){
			return;
		}else {
			view_999( ct, pri, pub);
			return;
		}
	}

	private void view_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
