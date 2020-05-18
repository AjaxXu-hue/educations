package org.demo.system.service.lecturer;

public interface LeMailService {

    //发送简单邮箱
    //发送人、收件人、抄送人、邮件主题、邮件内容
    public void sendMail(String from, String to, String cc, String subject, String content);


}
