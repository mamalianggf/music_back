package com.gf.music.service.impl;

import com.gf.music.domain.User;
import com.gf.music.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.username}")
    private String username;
    @Value("${server.port}")
    private String port;

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendMail(User user) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessage.setFrom(username);
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setSubject("FoxMusic verify your email");
        //todo 部署时要修改url+ip
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>FoxMusic</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>FoxMusic：</h1>\n" +
                "\t<p>亲爱的：" + user.getName() + "</p>\n" +
                "\t<p>欢迎加入FoxMusic！</p>\n" +
                "\t<p>请点击<a href=\"http:localhost:"+port+"/user/active?id=" + user.getId()+"\"" + ">这里</a>激活邮箱完成注册并登录！</p>\n" +
                "\t<p></p>\n" +
                "\t<p>这是一封自动产生的email，请勿回复！</p>\n" +
                "\t<p>----------------------------------</p>\n" +
                "</body>\n" +
                "</html>";
        mimeMessageHelper.setText(html, true);
        javaMailSender.send(mimeMessage);
    }
}
