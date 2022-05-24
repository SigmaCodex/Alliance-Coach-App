package com.alliance.coaching.util;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 19, 2022 11:36 PM
 */

@Service
@RequiredArgsConstructor
public class Email {

    private final JavaMailSender mailSender;
    private String to = "ai.coachingapp@gmail.com";
    private String sender = "";
    private String senderEmail = "";
    private String senderContact = "";

    public void setTo(String to) {
        this.to = to;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public void setSenderContact(String senderContact) {
        this.senderContact = senderContact;
    }

    public void sendNewForm() {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(String.valueOf(new InternetAddress("ai.coachingapp@gmail.com", "Coaching App")));
            helper.setTo(to);
            helper.setSubject("New Coaching Form");
            helper.setText("" +
                    "<html>" +
                    "<body>" +
                    "<h3>Attached below is a new form created by " + sender + ".</h3>" +
                    "<h3>If you have any clarifications, you may contact them thru " + senderEmail + " or " + senderContact + ".</h3>" +
                    "</body>" +
                    "</html>" +
                    "", true);
            mailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

    public void sendUpdatedForm() {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(String.valueOf(new InternetAddress("ai.coachingapp@gmail.com", "Coaching App")));
            helper.setTo(to);
            helper.setSubject("New Coaching Form");
            helper.setText("" +
                    "<html>" +
                    "<body>" +
                    "<h3>Attached below is an updated form created by " + sender + ".</h3>" +
                    "<h3>If you have any clarifications, you may contact them thru " + senderEmail + " or " + senderContact + ".</h3>" +
                    "</body>" +
                    "</html>" +
                    "", true);
            mailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

}
