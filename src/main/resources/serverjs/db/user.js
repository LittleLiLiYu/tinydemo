var User = function(){
	this.table_name = "user";
	this.id_name = "id";
	this.fields = {
		id:0,
		name:"",
		age:0,
		sex:"",
		address:""
		//create_time:"CURRENT_TIMESTAMP"
	}
	this.sql = {
			all:"select * from user limit 1"
	}
}
User.prototype = new db(this);