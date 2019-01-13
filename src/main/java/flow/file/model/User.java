package flow.file.model;

/**
*this is db model fileuser.js to change,
*do not modify by manual,thank you
*/
import cn.sunline.tiny.core.data.database.*;
import java.util.*;
public class User extends ModelDB {


protected  String getTableName(){return "user";}
protected  String getTableId(){return "id";}
public Long id;
public String name;
public Long age;
public String sex;
public String address;
public static UserSql sql=  new UserSql(); 
public static class UserSql { 
public String all="select * from user limit 1";
	}
protected  static List<String> fields = new ArrayList<String>();
protected  List<String> getFields(){return fields;}
static {
fields.add("id");
fields.add("name");
fields.add("age");
fields.add("sex");
fields.add("address");
}
}
