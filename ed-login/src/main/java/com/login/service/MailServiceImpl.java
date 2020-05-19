package com.login.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

//@Component
@Service
public class MailServiceImpl implements MailService{

    @Autowired
    JavaMailSender javaMailSenders;

    //发送简单邮箱
    //发送人、收件人、抄送人、邮件主题、邮件内容
    public void sendMail(String from , String to , String cc , String subject , String content){
        SimpleMailMessage simple = new  SimpleMailMessage();
        simple.setFrom(from);
        simple.setTo(to);
        simple.setCc(cc);
        simple.setSubject(subject);
        simple.setText(content);
        javaMailSenders.send(simple);
    }
}
