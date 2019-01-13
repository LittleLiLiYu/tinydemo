package flow.file;

/**
*this is flow filetest_dao.flow to change,
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

@Service("test_dao_flow")
public class Test_daoFlow extends BaseFlow implements RunFlow{
	private static final Logger log = LoggerFactory.getLogger(Test_daoFlow.class);
	public  Test_daoFlow(){
	}
	public int action(Context ct){
		String flowsn = ct.getFlowsn();
		if(flowsn.equals("1")){
 		 try{
 		 	test_dao_1(ct,ct.getPriDataCache(),ct.getPubDataCache());
 		 }catch(Exception ex){
 		 	log.error(ex.getMessage(),ex);
 		 	flowERROR(ct,ct.getPriDataCache(),ex);
 		 }
		}
			 return 0;
	}

	private void test_dao_1(Context ct,PriCache pri,PubCache pub){
pri.put("name","yu");  //flow->8//
//queryList查询列表数据 //flow->9//
 pri.put("list",getDao().queryList("select name,age from user"));  //flow->10//
log.info("list:"+((List<Map<String,Object>>)pri.get("list"))); //flow->11//
log.info("list size:"+((List<Map<String,Object>>)pri.get("list")).size()); //flow->12//
 //flow->13//
if(equals(((List<Map<String,Object>>)pri.get("list")).size(),0)){ //flow->14//
pri.put("view","无数据"); //flow->15//
}else{ //flow->16//

test_dao_10(ct,pri,pub);
 return  ; //flow->17//
} //flow->18//
 //flow->19//	}

	private void test_dao_10(Context ct,PriCache pri,PubCache pub){
JSONObject jsons = toJSON() 
 ; //flow->23//
    jsons.put("rows",toJSONList());   //flow->24//
    for(int iiii=0;iiii<((List<Map<String,Object>>)pri.get("list")).size();iiii++){
Map<String,Object> o=(Map<String,Object>)((List<Map<String,Object>>)pri.get("list")).get(iiii);    //flow->25//
    log.debug(""+o); //flow->26//
     (jsons.getJSONArray("rows")).add(toJSON("name",(o.get("name")),"age",(o.get("age"))) 
); //flow->27//
};   //flow->28//
 pri.put("view",cn.sunline.tiny.core.util.JSON.stringify(jsons));  //flow->29//
 
	}

	private void test_dao_999(Context ct,PriCache pri,PubCache pub){
	flow_999(ct,pri,pub);
	}

}
