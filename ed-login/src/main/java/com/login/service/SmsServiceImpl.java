package com.login.service;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/*
手机短信
 */
@Service(value = "smsService")
public class SmsServiceImpl implements SmsService{
    @Override
    //发送接口(单个发送   发送电话号码,官网ID,内容)
    public void send(String to, String templateId, String[] datas) {
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init("app.cloopen.com" , "8883");//初始生产url
        sdk.setAccount("8a216da86f9cc12f017006a2f4972421" , "499563382fc84d22adf5eefb53bd5108");
        sdk.setAppId("8aaf0708701ea9ab01703a6b7e1d0bac");

        HashMap<String, Object> result = sdk.sendTemplateSMS(to, templateId, datas);
        //判断发送是否成功
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            System.out.print("短信发送成功");
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
    }
}
