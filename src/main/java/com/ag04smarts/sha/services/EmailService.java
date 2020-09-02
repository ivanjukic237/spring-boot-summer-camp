package com.ag04smarts.sha.services;

public interface EmailService {

    void sendSimpleMessage(
            String to, String subject, String text);
}
