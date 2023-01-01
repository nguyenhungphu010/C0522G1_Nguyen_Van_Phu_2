package com.example.book_store.service.email;

import com.example.book_store.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private IUserService userService;

    @Override
    public boolean sendEmail(String receiveMail, String link) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

            helper.setFrom("c0522g2@gmail.com");
            helper.setTo(receiveMail);
            String subject = "Hóa đơn mua hàng";
            String content = "đây là hóa đơn mua hàng của bạn";

            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public String findCustomerEmail(String username) {
        return this.userService.getCustomerEmail(username);
    }
}
