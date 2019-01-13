package flow.file.model;

/**
*this is db model filetest.js to change,
*do not modify by manual,thank you
*/
import cn.sunline.tiny.core.data.database.*;
import java.util.*;
public class Test extends ModelDB {


protected  String getTableName(){return "test";}
protected  String getTableId(){return "id";}
public Long id;
public String name;
public Long age;
public String sex;
public String address;
public Date create_time;
public Date modify_date;
public static TestSql sql=  new TestSql(); 
public static class TestSql { 
public String all="select * from test";
	}
protected  static List<String> fields = new ArrayList<String>();
protected  List<String> getFields(){return fields;}
static {
fields.add("id");
fields.add("name");
fields.add("age");
fields.add("sex");
fields.add("address");
fields.add("create_time");
fields.add("modify_date");
}
}
