var Test = function(){
	this.table_name = "test";
	this.id_name = "id";
	this.fields = {
		id:0,
		name:"",
		age:0,
		sex:"",
		address:"",
		create_time:"CURRENT_TIMESTAMP",
		modify_date:"CURRENT_TIMESTAMP"
	}
	this.sql = {
		all:"select * from test"
	}
}
Test.prototype = new db(this);