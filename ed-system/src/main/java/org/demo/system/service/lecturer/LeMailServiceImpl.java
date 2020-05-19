package org.demo.system.service.lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LeMailServiceImpl implements LeMailService {

    @Autowired
    JavaMailSender javaMailSender;

    //发送简单邮箱
    //发送人、收件人、抄送人、邮件主题、邮件内容
    public void sendMail(String from , String to , String cc , String subject , String content){
        SimpleMailMessage simple = new  SimpleMailMessage();
        simple.setFrom(from);
        simple.setTo(to);
        simple.setCc(cc);
        simple.setSubject(subject);
        simple.setText(content);
        javaMailSender.send(simple);
    }
}
