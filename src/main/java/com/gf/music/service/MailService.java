package com.gf.music.service;

import com.gf.music.domain.User;

import javax.mail.MessagingException;

public interface MailService {

    void sendMail(User user) throws MessagingException;
}
