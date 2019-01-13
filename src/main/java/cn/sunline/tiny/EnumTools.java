package cn.sunline.tiny;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component("enumTools")
public class EnumTools   {
	
	@SuppressWarnings("serial")
	public  Map<String,String> EnumErrorMsg= new HashMap<String,String>(){ 
		{ 
			put("0001","交易失败，请稍后再试");
			put("0002","手机号获取短信验证码过于频繁，请稍后再试");
			put("0003","获取短信验证码过于频繁，请稍后再试");
			put("0005","系统繁忙，请稍后再试");
			put("0006","图形验证码错误");
			put("0007","系统繁忙，请稍后再试");
			put("0008","请获取图形验证码");
			put("0009","系统繁忙，请稍后再试");
			put("9001","系统繁忙，请稍后再试");
			put("9002","系统繁忙，请稍后再试");
			put("100000","登录超时，请重新登录");
			put("100001","两次密码不一致，请重新输入");
			put("1001","请输入正确手机号");
			put("1002","请收入正确身份证号");
			put("1003","请输入正确银行卡号");
			put("1004","请输入有效金额");
			put("1008","未满18周岁，暂不能绑定银行卡");
			put("1009","请输入正确姓名");
			put("1010","意见或建议描述字数超限");
			put("1011","新密码和旧密码不能相同");
			put("100021","登录超时，请重新登录");
			put("100022","手势密码已失效，请重新登录");
			put("100023","设备已被锁定，请稍后再试");
			put("100024","权限受限，暂不允许使用该功能");
			put("100025","系统繁忙);请稍后再试[100025]");
			put("100026","您已投过票");
			put("100027","请先投票");
		}
			
	};
	
	@SuppressWarnings("serial")
	public Map<String,String> EnumBffTransNew= new HashMap<String,String>(){ 
		{
			put("0","处理中");
			put("1","交易成功");
			put("2","交易失败");
			put("3","申请已受理");
			put("4","交易失败");
			put("5","申请已受理");
			put("6","处理中");
			put("7","赎回成功待充值");
			put("8","交易失败退款中");
			put("9","撤单处理中");
			put("a","已撤单");
			put("b","申请已受理");
		}
	};
	
}
