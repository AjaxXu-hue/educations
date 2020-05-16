package com.login.service;

/*
发送短信接口
 */
public interface SmsService {
    //发送接口(单个发送   发送电话号码,官网ID,内容)
    public void send(String to, String templateId, String[] datas);
}
