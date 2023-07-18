package com.fch.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 短信发送工具类
 */
public class SMSUtil {
	//在阿里云短息服务->国内消息->模板管理查看
	public static final String VALIDATE_CODE = "SMS_154950909";//发送短信验证码

	/**
	 * 发送短信
	 * @param templateCode 模板CODE
 	 * @param phoneNumbers 手机号
 	 * @param param  参数
	 */
	public static void sendMessage(String templateCode,String phoneNumbers,String param) throws ClientException {
		// 设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");

		// 初始化ascClient需要的几个参数
		final String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
		final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
		// 你的accessKeyId
		final String accessKeyId = "LTAI5tCeTcQcTkKpmHhPENsr";
		// 你的accessKeySecret
		final String accessKeySecret = "jbKy7vfYe9XJEsqeyo9glAk08Vg0r4";

		// 初始化ascClient,暂时不支持多region（请勿修改）
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient client = new DefaultAcsClient(profile);

		// 组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		// 使用post提交
		request.setMethod(MethodType.POST);
		// 必填:短信签名-可在短信控制台中找到
		request.setSignName("阿里云短信测试");
		// 必填:短信模板-可在短信控制台中找到
		request.setTemplateCode(templateCode);
		// 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
		request.setPhoneNumbers(phoneNumbers);
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		// 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		request.setTemplateParam("{\"code\":\""+param+"\"}");

		try {
			//发起请求
			SendSmsResponse response = client.getAcsResponse(request);
			//{"requestId":"6202C325-C186-50F1-B481-6D042313AB0C","bizId":"889321576984972364^0","code":"OK","message":"OK"}
			System.out.println(new Gson().toJson(response));
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			System.out.println("ErrCode:" + e.getErrCode());
			System.out.println("ErrMsg:" + e.getErrMsg());
			System.out.println("RequestId:" + e.getRequestId());
		}
	}


	public static void main(String[] args) throws ClientException {
		sendMessage(VALIDATE_CODE , "19810901507" , ValidateCodeUtil.generateValidateCode4String(4));

		LocalDate orderDate = LocalDate.parse("2023-07-17" , DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		//2023-02-26  ->  23-02-26  ->  230226  验证码4~6位
		String format = orderDate.format(DateTimeFormatter.ofPattern("yy-MM-dd"));
		String param = format.replaceAll("-","");
		//sendMessage(SMSUtil.ORDER_NOTICE , "19810901507" , param);
	}
}
