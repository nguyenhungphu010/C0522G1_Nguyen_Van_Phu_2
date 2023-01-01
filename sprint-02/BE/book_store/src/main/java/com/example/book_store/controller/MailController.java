package com.example.book_store.controller;


import com.example.book_store.service.email.IMailService;
import com.example.book_store.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RequestMapping("api/send-mail")
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private IUserService userService;

    @PostMapping("")
    public void sendReceiptMail(@RequestParam(value = "username", defaultValue = "") String username) {
        String customerEmail = this.userService.getCustomerEmail(username);
        if (customerEmail != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("[Thông tin hóa đơn] của khách hàng");
            message.setText("đây là nội dung email");
            this.javaMailSender.send(message);
        } else {
            System.out.println(" không thể gửi email");
        }
    }
}
