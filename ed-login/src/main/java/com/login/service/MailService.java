package com.login.service;

public interface MailService {

    //发送简单邮箱
    //发送人、收件人、抄送人、邮件主题、邮件内容
    public void sendMail(String from , String to , String cc , String subject , String content);


}
