package com.example.book_store.service.email;

public interface IMailService {
    boolean sendEmail(String receiveMail, String link);

    String findCustomerEmail(String username);
}
