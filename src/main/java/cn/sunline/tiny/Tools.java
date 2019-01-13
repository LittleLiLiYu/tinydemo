package cn.sunline.tiny;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.sunline.tiny.core.BeanFactory;
import cn.sunline.tiny.core.Constant;
import cn.sunline.tiny.core.PubCache;
import cn.sunline.tiny.core.data.database.TinyJdbcDao;
import cn.sunline.tiny.web.Context;
import cn.sunline.tiny.web.cache.SysConfig;
import cn.sunline.tiny.web.util.FlowUtil;

@Component("Tools")
public class Tools {

	private static final Logger LOG = LoggerFactory.getLogger(Tools.class);

	public Tools() {
	}

	public boolean isAmount(String param) {

		return param.matches("^((([1-9]{1}\\d{0,9}))|([0]{1}))((\\.(\\d){1,2}))?$");
	}


	public String encodeURIComponent(String param) {
		try {
			return java.net.URLEncoder.encode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return param;
	}

	public String getGiftAcctNo(Context ct) {
		PubCache pub = ct.getPubDataCache();
		if (!isNull(pub) && !isNull(pub.get("acctInfo"))) {
			JSONObject accountInfo = (JSONObject) ct.getPubDataCache().get("acctInfo");

			if (accountInfo.getJSONArray("laInfo").size() > 0) {
				List<Object> laaccountList = (List<Object>) accountInfo.getJSONArray("laInfo");
				JSONObject acct = (JSONObject) laaccountList.get(0);
				return acct.getString("acct_no");
			} else if (accountInfo.getJSONArray("faInfo").size() > 0) {
				List<Object> faaccountList = (List<Object>) accountInfo.getJSONArray("faInfo");
				JSONObject acct = (JSONObject) faaccountList.get(0);
				return acct.getString("acct_no");
			} else if (accountInfo.getJSONArray("saInfo").size() > 0) {
				List<Object> faaccountList = (List<Object>) accountInfo.getJSONArray("saInfo");
				JSONObject acct = (JSONObject) faaccountList.get(0);
				return acct.getString("acct_no");
			}
		}
		return "";
	}

	public Date getNow() {
		return new Date();
	}

	public void logdebug(String str, Context ct) {
		String path = ct.getRequest().getRequestURI();
		String realPath = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf(".tml"));
		LOG.info("[" + realPath + "]:" + str);
	}

	// 时间顺序格式转换
	public String formatetime(String timestr, String seperator1) {
		if ("".equals(seperator1) || seperator1 == null)
			seperator1 = "/";
		return timestr.substring(8, 10) + seperator1 + timestr.substring(5, 7) + seperator1 + timestr.substring(0, 4)
				+ " " + timestr.substring(11);
	}

	public String formatetime(String timestr) {
		String seperator1 = "/";
		return timestr.substring(8, 10) + seperator1 + timestr.substring(5, 7) + seperator1 + timestr.substring(0, 4)
				+ " " + timestr.substring(11);
	}

	public String formatetimecancel(String timestr, String seperator1) {
		if ("".equals(seperator1) || seperator1 == null)
			seperator1 = "-";
		return timestr.substring(6, 10) + seperator1 + timestr.substring(3, 5) + seperator1 + timestr.substring(0, 2)
				+ " " + timestr.substring(11);
	}

	public String formatetimecancel(String timestr) {
		String seperator1 = "-";
		return timestr.substring(6, 10) + seperator1 + timestr.substring(3, 5) + seperator1 + timestr.substring(0, 2)
				+ " " + timestr.substring(11);
	}

	// 当前/指定 年月日时分秒
	public String currentDateNum(Date nowdate) {
		if (nowdate == null) {
			nowdate = new Date();
		}
		DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = null;
		dateString = format2.format(nowdate);
		return dateString;
	}

	// 当前/指定 年月日时分秒
	public String currentDateNum() {
		return currentDateNum(new Date());
	}

	// 当前/指定 年月日时分秒
	public String currentDateNum(String nowdate) {
		Date date = strToDate(nowdate);
		return currentDateNum(date);
	}

	// 当前/指定 年月日
	public String currentYMDNum(Date nowdate) {
		if (nowdate == null) {
			nowdate = new Date();
		}
		DateFormat format2 = new SimpleDateFormat("yyyyMMdd");
		String dateString = null;
		dateString = format2.format(nowdate);
		return dateString;
	}

	// 当前/指定 年月日
	public String currentYMDNum(String nowdate) {
		Date date = strToDate(nowdate);
		return currentYMDNum(date);
	}

	// 当前/指定 年月日
	public String currentYMDNum() {
		return currentYMDNum(new Date());
	}

	// 当前/指定 年-月-日 时:分:秒
	public String currentDate(Date nowdate) {
		if (nowdate == null) {
			nowdate = new Date();
		}
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = null;
		dateString = format2.format(nowdate);
		return dateString;
	}

	// 当前/指定 年-月-日 时:分:秒
	public String currentDate(String nowdate) {
		Date date = strToDate(nowdate);
		return currentDate(date);
	}

	// 当前/指定 年-月-日 时:分:秒
	public String currentDate() {
		return currentDate(new Date());
	}

	// 当前/指定 年-月-日
	public String currentYMD(Date nowdate) {
		if (nowdate == null) {
			nowdate = new Date();
		}
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = null;
		dateString = format2.format(nowdate);
		return dateString;
	}

	public String currentYMD() {
		return currentYMD(new Date());
	}

	// 当前/指定 年-月-日
	public String currentYMD(String nowdate) {
		Date date = strToDate(nowdate);
		return currentYMD(date);
	}

	// 当前/指定 时:分:秒
	public String currentHMS(Date nowdate) {
		if (nowdate == null) {
			nowdate = new Date();
		}
		DateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String dateString = null;
		dateString = format2.format(nowdate);

		return dateString;
	}

	public String currentHMS(String nowdate) {
		Date date = strToDate(nowdate);
		return currentHMS(date);
	}

	public String currentHMS() {
		return currentHMS(new Date());
	}

	public String getUserName(int id, Context ct) {

		List<Object> usersList = (List<Object>) ct.getPubDataCache().get("users");

		for (int i = 0; i < usersList.size(); i++) {
			JSONObject user = (JSONObject) usersList.get(i);
			if (user.getInteger("id") == id) {
				return user.getString("real_name");
			}
		}
		return "";
	}

	/*
	 * 获取当前的日期时间 格式"yyyy-MM-dd HH:MM:SS"
	 */
	public String getNowFormatDate(String format) {
		DateFormat format1 = new SimpleDateFormat(format);
		Date date = new Date();
		String dateString = null;

		dateString = format1.format(date);
		return dateString;
	}

	/*
	 * 根据format格式返回日期 格式"yyyy-MM-dd"
	 */
	public String getFormatDate(String format, String orderDate) {
		Date date = strToDate(orderDate);
		return getFormatDate(format, date);
	}

	public String getFormatDate(String format, Date orderDate) {
		DateFormat format2 = new SimpleDateFormat(format);
		String dateString = null;
		dateString = format2.format(orderDate);
		return dateString;
	}

	public List<String> unique(List<String> arr) { // 剔除重复数据
		List<String> result = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			if (!result.contains(arr.get(i))) {
				result.add(arr.get(i));
			}
		}
		return result;
	}

	public boolean contains(Object[] arr, Object obj) {
		int i = arr.length;
		while (i >= 0) {
			if (arr[i].equals(obj)) {
				return true;
			}
			i--;
		}
		return false;
	}

	/*
	 * 获取验证码
	 */
	public String getCheckCode(int codeLen) {
		String checkCode = "";
		int len = 0;

		while (true) {
			if (len >= codeLen) {
				return checkCode;
			}
			int c = (int) (Math.random() * 10);
			if (checkCode.indexOf(Integer.toString(c)) >= 0)
				continue;
			checkCode += c;
			len++;
		}
	}

	/*
	 * 判断字符串是否为空
	 */
	public boolean isNull(Object o) {
		if (o == null) {
			return true;
		}

		if (o instanceof String) {
			String str = o.toString();

			if (str == null || "".equals(str) || str == "null" || str == "undefined") {
				return true;
			}
		} else if (o instanceof JSONArray) {
			return ((JSONArray) o).size() == 0;
		} else if (o instanceof List) {
			return ((List) o).size() == 0;
		}

		return false;
	}

	// 为t_dictionary的enum服务
	public String selectEnumName(List<Object> list, String key) {
		for (int i = 0, length = list.size(); i < length; i++) {
			if (((JSONObject) list.get(i)).get("dict_key") == key) {
				return (String) ((JSONObject) list.get(i)).get("dict_name");
			}
		}
		return null;
	}

	public String uuid() {
		return UUID.randomUUID().toString();
	}

	public String getUUID() {
		return UUID.randomUUID().toString();
	}

	// 获取服务端对外地址(APP访问地址)
	public String getRequestUrl() {
		String url = SysConfig.getInstance().getValue("url");
		LOG.debug("getRequestUrl:" + url);
		return url;
	}

	public boolean isExpire(String createTime) {

		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date2 = null;
		Date date1 = null;
		try {
			date2 = format1.parse(createTime);
			date1 = format1.parse(getFormatDate("yyyy-MM-dd HH:MM:SS", new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long s1 = date1.getTime();
		long s2 = date2.getTime();
		long total = (s1 - s2) / 1000;
		long expireTime = 24 * 60 * 60;
		if (total > expireTime) {
			return true;
		}
		return false;
	}

	public String getOTPNum() {
		// 0-9的随机数
		String arr = "";// 容器
		for (int i = 0; i < 6; i++) {// 循环六次
			double num = Math.random() * 10;// Math.random();每次生成(0-1)之间的数;
			int an = (int) num;
			arr += Integer.toString(an);
		}
		return arr;
	};

	public String getPwdRandom() {
		// 0-9的随机数
		String arr = "";// 容器
		for (int i = 0; i < 16; i++) {// 循环六次
			double num = Math.random() * 10;// Math.random();每次生成(0-1)之间的数;
			int an = (int) num;
			arr += Integer.toString(an);
		}
		return arr;
	};

	public String formatEmail(String str, String cont) {
		return "<a href=" + str + " >" + cont + "</a>";
	}

	// JSON.stringify()形成的strArr
	public boolean strInIfyArr(String str, String arr) {
		str = ",\"" + str + "\",";
		arr = "," + arr.substring(1, arr.length() - 1) + ",";
		if (arr.indexOf(str) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	// toString()形成的strArr
	public boolean strInToStrArr(String str, String strArr) {
		str = "," + str + ",";
		String arr = "," + strArr + ",";
		if (arr.indexOf(str) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean strInArr(String str, JSONArray arr) {
		String strArr = arr.toString();
		return strInIfyArr(str, strArr);
	}

	public boolean strInArr(String str, JSONObject arr) {
		String strArr = arr.toString();
		return strInIfyArr(str, strArr);
	}

	public Date strToDate(String dateStr) {
		Date date = null;
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if ("".equals(dateStr) || dateStr == null || dateStr.equals(null)) {
			date = new Date();
		} else {
			try {
				date = format1.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	// 格式化customer code
	public String format_customer_code(String serviceId, String providerId) {
		JSONArray array1 = new JSONArray();
		array1.add("AIA");
		array1.add("FWD");
		array1.add("MVL");
		array1.add("AVG");
		array1.add("HTVC");
		array1.add("SCTVTHC");

		JSONArray array2 = new JSONArray();
		array2.add("KPLUS");

		JSONArray array3 = new JSONArray();
		array3.add("VTC");

		JSONArray array4 = new JSONArray();
		array4.add("SPT");
		array4.add("SST");
		array4.add("VIETTEL");
		array4.add("MOBI");
		array4.add("VINASG");
		array4.add("VNMOBILE");

		JSONArray array5 = new JSONArray();
		array5.add("SPT");
		array5.add("SST");

		String contract_number_arrstr = array1.toString();
		String card_number_arrstr = array2.toString();
		String service_code_arrstr = array3.toString();
		String phone_number_arrstr = array4.toString();
		String username_arrstr = array5.toString();
		// 不能放开serviceId,不同的service下的相同providerId,标识不同
		String rstr = "CUSTOMER CODE";
		if (serviceId.equals("BH")) {
			// Insurance
			if (strInIfyArr(providerId, contract_number_arrstr)) {
				rstr = "CONTRACT NUMBER";
			}
		} else if (serviceId.equals("CAP")) {
			// Television
			if (strInIfyArr(providerId, contract_number_arrstr)) {
				rstr = "CONTRACT NUMBER";
			} else if (strInIfyArr(providerId, card_number_arrstr)) {
				rstr = "CARD NUMBER";
			} else if (strInIfyArr(providerId, service_code_arrstr)) {
				rstr = "SERVICE CODE";
			}
		} else if (serviceId.equals("DTCDCD")) {
			// Fixed phone
			if (strInIfyArr(providerId, phone_number_arrstr)) {
				rstr = "PHONE NUMBER";
			}
		} else if (serviceId.equals("DTDDTQ")) {
			if (strInIfyArr(providerId, phone_number_arrstr)) {
				rstr = "PHONE NUMBER";
			}
		} else if (serviceId.equals("NET")) {
			if (strInIfyArr(providerId, contract_number_arrstr)) {
				rstr = "CONTRACT NUMBER";
			} else if (strInIfyArr(providerId, username_arrstr)) {
				rstr = "USERNAME";
			}
		}
		return rstr;
	}

	// 判断是否是18岁
	public boolean is18Age(String birthday) {
		boolean flag = false;
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String[] nowDates = format1.format(date).split("-");
		String[] birthdays = birthday.split("-");
		LOG.debug("nowDates=============:" + nowDates);
		LOG.debug("birthdays============:" + birthdays);
		if (Integer.parseInt(nowDates[0]) - Integer.parseInt(birthdays[0]) < 18) {
			flag = false;
		}
		if (Integer.parseInt(nowDates[0]) - Integer.parseInt(birthdays[0]) > 18) {
			flag = true;
		}
		if (Integer.parseInt(nowDates[0]) - Integer.parseInt(birthdays[0]) == 18) {
			if (Integer.parseInt(nowDates[1]) - Integer.parseInt(birthdays[1]) < 0) {
				flag = false;
			}
			if (Integer.parseInt(nowDates[1]) - Integer.parseInt(birthdays[1]) > 0) {
				flag = true;
			}
			if (Integer.parseInt(nowDates[1]) - Integer.parseInt(birthdays[1]) == 0) {
				if (Integer.parseInt(nowDates[2]) - Integer.parseInt(birthdays[2]) == 0) {
					flag = true;
				}
				if (Integer.parseInt(nowDates[2]) - Integer.parseInt(birthdays[2]) > 0) {
					flag = true;
				}
				if (Integer.parseInt(nowDates[2]) - Integer.parseInt(birthdays[2]) < 0) {
					flag = false;
				}
			}
		}
		return flag;
	}

	// 生成推荐码
	public String generateRefCode(String real_name) {
		String[] names = real_name.split(" ");
		String name = names[names.length - 1];
		if (name.length() > 5) {
			name = name.substring(0, 5);
		}
		int i = 1;
		String refCode;

		TinyJdbcDao dao = BeanFactory.getBean(Constant.TINYJDBCDAO);
		String sql = "select * from t_user where my_referral_code = ?";
		Map<String, Object> user = null;
		do {
			user = null;
			String suffix = null;
			if (i < 10) {
				suffix = "00" + i;
			} else if (i > 10 && i < 100) {
				suffix = "0" + i;
			} else if (i > 100) {
				suffix = i + "";
			}
			refCode = name + suffix;
			user = dao.queryOne(sql, refCode);
			i++;
		} while (!(user == null));

		return refCode;
	}

	// 生成最小值跟最大值可配置的随机数
	// 100的整数倍
	public int getRandomNum(int Min, int Max) {
		int Range = Max - Min;
		double Rand = Math.random();
		long result = Min * 1 + Math.round(Rand * Range) * 1;
		int tt = (int) (result / 100);
		return tt * 100;
	}

	// 解析指纹校验的结果
	public boolean checkFingerPassword(String finger_password, Context ct) {
		String code = FlowUtil.getInstance().RSADecode(finger_password, ct.getPubDataCache().getParam("pri_key"));
		if ("0000".equals(code)) {
			return true;
		}
		return false;
	}

	/**
	 * 邮箱格式校验
	 * 
	 * @param elementId 元素ID
	 * @returns 校验结果 true - 通过，false - 未通过
	 */
	public boolean checkEmail(String email) {
		// if
		// (/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.\-]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/i.test(email)){
		// return true;
		// }
		boolean flag = false;
		try {
			String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	// 处理核心返回码
	public String icoreCode(String erorcd) {
		if ("0000".equals(erorcd)) {
			return "000000";
		} else {
			return "40" + erorcd;
		}
	}

	// 处理卡系统返回码
	public String cardCode(Object erorcd) {
		if ("0000".equals(erorcd.toString())) {
			return "000000";
		} else {
			return "50" + erorcd;
		}
	}

	// 处理OTP返回码
	public String otpCode(String errorCode) {
		if ("1".equals(errorCode)) {
			return "000000";
		} else if ("-1".equals(errorCode)) {
			return "730001";
		} else if ("-3".equals(errorCode)) {
			return "730003";
		} else if ("-4".equals(errorCode)) {
			return "730004";
		} else if ("-7".equals(errorCode)) {
			return "730007";
		} else if ("-8".equals(errorCode)) {
			return "730008";
		} else if ("-9".equals(errorCode)) {
			return "730009";
		} else if ("102".equals(errorCode)) {
			return "110007";
		} else if ("100".equals(errorCode)) {
			return "231007";
		} else {
			return "730001";
		}
	}

	// 姓名缩写
	public String shortenName(String name) {
		if (name.length() <= 22) {
			return name;
		} else {
			String short_name = "";
			String[] names = name.split(" ");
			for (int i = 0; i < names.length; i++) {
				if (i > 0 && i < (names.length - 1)) {
					names[i] = names[i].substring(0, 1);
				}
				short_name += names[i];
				short_name += " ";
			}
			short_name = short_name.substring(0, short_name.length() - 1);
			return (short_name.length() > 22 ? -1 : short_name).toString();
		}
	}

	public void returnAgentMsg(String erorcd, String erortx, Context ct) {
		returnAgentMsg(erorcd, erortx, null, ct);
	}

	// 用于处理代理报错信息
	public void returnAgentMsg(String erorcd, String erortx, JSONObject robj, Context ct) {
		JSONObject dataJson = new JSONObject();
		HttpServletRequest req = ct.getRequest();
		if (req != null) {
			String path = req.getRequestURI();
			dataJson.put("transCode", path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf(".tml")));
		} else {
			dataJson.put("transCode", "other");

		}
		dataJson.put("rcode", erorcd);
		dataJson.put("rtime", currentDate());
		dataJson.put("msg", erortx);

		if (robj != null) {
			dataJson.put("robj", robj);
		}
		LOG.debug("dataJson:" + dataJson.toString());
		ct.getPriDataCache().setParam("view", dataJson.toString());
	}

	// 转换语言
	public int langType(String str) {
		if ("zh-Hans".equals(str) || "zh-cn".equals(str) || "cnl".equals(str)) {
			return 1;
		} else if ("en-EN".equals(str)) {
			return 2;
		} else if ("vi_VN".equals(str)) {
			return 3;
		} else {
			return 2;
		}
	}

	// 判断上午下午 1-上午，2-下午
	public int getTimeslot() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR);

		return hour >= 12 ? 2 : 1;
	}

	// 按照日期时间对json进行排序
	public JSONArray sortJsonByDate(JSONArray jsonArr, String keyName) {
		JSONArray sortedJsonArray = new JSONArray();
		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		for (int i = 0; i < jsonArr.size(); i++) {
			jsonValues.add(jsonArr.getJSONObject(i));
		}
		Collections.sort(jsonValues, new Comparator<JSONObject>() {
			private final String KEY_NAME = keyName;

			@Override
			public int compare(JSONObject a, JSONObject b) {
				String valA = (String) a.get(KEY_NAME);
				String valB = (String) b.get(KEY_NAME);
				valA = valA.replaceAll("[^0-9]", "");
				valB = valB.replaceAll("[^0-9]", "");
				int paramA = Integer.parseInt(valA);
				int paramB = Integer.parseInt(valA);
				if (paramA >= paramB) {
					return 1;
				} else {
					return -1;
				}
				// return valA.compareTo(valB);
			}
		});

		for (int i = 0; i < jsonArr.size(); i++) {
			sortedJsonArray.add(jsonValues.get(i));
		}
		return sortedJsonArray;
	}

	public String otpRandCode(int length) {
		// A-Z的随机字母
		String strCode = "";
		// 用字符数组的方式随机
		String model = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] m = model.toCharArray();
		for (int j = 0; j < length; j++) {
			char c = m[(int) (Math.random() * 25)];
			// 保证六位随机数之间没有重复的
			strCode = strCode + c;
		}
		return strCode;
	}

	/**
	 * 手机号码格式化
	 */
	public String formatMobile(String mobileNumber) {
		return mobileNumber.substring(0, 1) == "0" ? mobileNumber : "0" + mobileNumber;
	}

	/**
	 * 手机号码格式校验
	 * 
	 * @param elementId 元素ID
	 * @returns 校验结果 true - 通过，false - 未通过
	 */
	public boolean checkMobile(String mobile) {
		String mobileNumber = formatMobile(mobile);
		if (Pattern.matches("^(08|09)[0-9]{9}$", mobileNumber)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 用户名校验
	 * 
	 * @param 元素ID
	 * @return 校验结果 true - 通过，false - 未通过
	 * 
	 */
	public boolean checkUsernameFormat(String username) {
		username = username.toLowerCase();
		boolean bool = Pattern.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$", username);
		return bool;
	}

	/**
	 * 姓名验证
	 * 
	 * @param 元素ID includblank为1时，需要校验，允许包含空格
	 * @return 校验结果
	 * 
	 */
	public boolean checkNameFormat(String name, String includblank) {
		name = name.toLowerCase();
		if (!isNull(includblank) && includblank == "1") {
			if (Pattern.matches("^[a-zA-Z/@\\.]+$", name)) {
				return true;
			}
		} else {
			if (Pattern.matches("^[a-zA-Z/@\\.]+$", name)) {
				return true;
			}
		}
		return false;
	}

	// 数组相减 return arr1中arr2没有的元素
	public ArrayList<String> subtractArr(ArrayList<String> arr1, ArrayList<String> arr2) {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < arr1.size(); i++) {
			if (!arr2.contains(arr1.get(i))) {
				newList.add(arr1.get(i));
			}
		}
		return (ArrayList<String>) newList;
	}

	// 根据存期获取到期日
	@SuppressWarnings("deprecation")
	public String getMaturityDate(String term_code, Date date) {
		String t1 = term_code.substring(term_code.length() - 1, term_code.length());
		int t2 = Integer.parseInt(term_code.substring(0, term_code.length() - 1));

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		if (t1 == "W") {
			t2 = t2 * 7;
			t1 = "D";
		}
		if (t1 == "D") {
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + t2 * 1);
		} else if (t1 == "M") {
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + t2 * 1);
		} else if (t1 == "Y") {
			cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + t2 * 1);
		}
		return cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);

	}

	public String getMaturityDate(String term_code, String nowdate) {
		Date date = null;
		try {
			date = (new SimpleDateFormat("yyyy-MM-dd")).parse(nowdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return getMaturityDate(term_code, date);
	}

	public String hideAcct(String acct_no) {
		if (!"".equals(acct_no)) {
			return "************" + acct_no.substring(acct_no.length() - 4);
		} else {
			return "";
		}
	}

	// 根据存期存期详细描述
	public String getDepositPeriod(String term_code, String language) {
		String t1 = term_code.substring(term_code.length() - 1, term_code.length());
		String t2 = term_code.substring(0, term_code.length() - 1);
		int lan = langType(language);

		// 目前要求无论什么语言环境都推送越南文
		lan = 3;

		String d = "";

		if (lan == 2) {
			switch (t1) {
			case "W":
				if (Integer.parseInt(t2) > 1) {
					d = "weeks";
				} else {
					d = "week";
				}
				break;
			case "M":
				if (Integer.parseInt(t2) > 1) {
					d = "months";
				} else {
					d = "month";
				}
				break;
			case "Y":
				if (Integer.parseInt(t2) > 1) {
					d = "years";
				} else {
					d = "year";
				}
				break;
			default:
				d = t1;
				break;
			}
		} else {
			switch (t1) {
			case "W":
				d = "tuần";
				break;
			case "M":
				d = "tháng";
				break;
			case "Y":
				d = "năm";
				break;
			default:
				d = t1;
				break;
			}
		}

		return t2 + " " + d;
	}

	/**
	 * 千分位转换方法
	 * 
	 * @param num  要转换的数字
	 * @param cent 保留的小数位数
	 */
	public String toThousands(String numStr, int cent) {
		DecimalFormat df = null;
		if (numStr.indexOf(".") > 0) {
			int i = numStr.length() - numStr.indexOf(".") - 1;
			if (cent >= 0) {
				i = cent;
			}
			switch (i) {
			case 0:
				df = new DecimalFormat("###,##0");
				break;
			case 1:
				df = new DecimalFormat("###,##0.0");
				break;
			case 2:
				df = new DecimalFormat("###,##0.00");
				break;
			case 3:
				df = new DecimalFormat("###,##0.000");
				break;
			case 4:
				df = new DecimalFormat("###,##0.0000");
				break;
			default:
				df = new DecimalFormat("###,##0.00000");
				break;
			}
		} else {
			df = new DecimalFormat("###,##0");
		}
		double number = 0.0;
		try {
			number = Double.parseDouble(numStr);
		} catch (Exception e) {
			number = 0.0;
		}
		return df.format(number);
	}

	/**
	 * 得到核心证件类型
	 * 
	 * @param certify_type app证件类型 1-身份证 2-护照
	 * @param certify_no   证件号码
	 */
	public String getDocType(String certify_type, String certify_no) {
		if (certify_type == "1") {
			if (certify_no.length() == 12) {
				return "10";
			} else {
				return "24";
			}
		} else {
			return "11";
		}
	}

	public boolean checkIsNumber(String num) {
		if (!Pattern.matches("^[0-9]*[1-9][0-9]*$", num)) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * 只允许字母，“ ”“/”或“@”或“.”
	 */
	public boolean com_firstName_check(String firstName) {
		return Pattern.matches("^[a-zA-Z/@ \\.]+$", firstName);
	}

	/*
	 * 只允许字母，“ ” “/”或“@”或“.” 开头不能为空格，中间不能有两个连续的空格
	 */
	public boolean com_surName_check(String name) {
		int result = 0;
		// return /^[a-zA-Z/@\.]+$/i.test(Name);
		if (Pattern.matches("^[a-zA-Z/@ \\.]+$", name)) {
			result |= 1;
		}
		if (Pattern.matches("^(?! .*)(?!.*  .*)(?!.* $).*", name)) {
			result |= 2;
		}
		if (result == 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断数字大小 eg. numberCompare("1",">","2.31") = false
	 * numberCompare("1.43567",">","1.4") = true
	 * 
	 * @param num1
	 * @param symbol <,<=,=,>=,>,!=
	 * @param num2
	 * @return
	 */
	public boolean numberCompare(String num1, String symbol, String num2) {
		num1 = isNull(num1) ? "0" : num1;
		num2 = isNull(num2) ? "0" : num2;
		int res = new BigDecimal(num1).compareTo(new BigDecimal(num2));
		if (res > 0) {
			// num1 > num2
			if (">".equals(symbol) || ">=".equals(symbol) || "!=".equals(symbol)) {
				return true;
			} else {
				return false;
			}
		} else if (res == 0) {
			// num1 = num2
			if ("=".equals(symbol) || ">=".equals(symbol) || "<=".equals(symbol)) {
				return true;
			} else {
				return false;
			}
		} else {
			// num1 < num2
			if ("<".equals(symbol) || "<=".equals(symbol) || "!=".equals(symbol)) {
				return true;
			} else {
				return false;
			}
		}
	}

}