package com.alliance.coaching.util;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
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
    private MultipartFile file = null;
    private String fileName = "";

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

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
                    "<h4>Attached below is a new form created by </h4><h3>" + sender + "</h3>." +
                    "<h4>If you have any clarifications, you may contact them thru </h4><h3>" + senderEmail + "</h3> or <h3>" + senderContact + "</h3>." +
                    "</body>" +
                    "</html>" +
                    "", true);
            helper.addAttachment(fileName, file);
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
            helper.setSubject("Updated Coaching Form");
            helper.setText("" +
                    "<html>" +
                    "<body>" +
                    "<h4>Attached below is the updated form created by </h4><h3>" + sender + "</h3>." +
                    "<h4>If you have any clarifications, you may contact them thru </h4><h3>" + senderEmail + "</h3> or <h3>" + senderContact + "</h3>." +
                    "</body>" +
                    "</html>" +
                    "", true);
            helper.addAttachment(fileName, file);
            mailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

    public void sendUpdateAction(String status, Long id, String actionPlan) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(String.valueOf(new InternetAddress("ai.coachingapp@gmail.com", "Coaching App")));
            helper.setTo(to);
            helper.setSubject("Update Coaching Form Action Plan");
            helper.setText("" +
                    "<html>" +
                    "<body>" +
                    "<h4>Attached below is the updated action plan created by </h4><h3>" + sender + "</h3>." +
                    "<h4>If you have any clarifications, you may contact them thru </h4><h3>" + senderEmail + "</h3> or <h3>" + senderContact + "</h3>." +
                    "<h4>Status: " + status + "</h4>" +
                    "<h4>Coach Form Id: " + id + "</h4>" +
                    "<h4>Action plan: " + actionPlan + "</h4>" +
                    "</body>" +
                    "</html>" +
                    "", true);
            helper.addAttachment(fileName, file);
            mailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

}
