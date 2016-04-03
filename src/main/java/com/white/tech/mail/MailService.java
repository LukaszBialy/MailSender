package com.white.tech.mail;

import com.white.tech.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
public class MailService {

    @Autowired
    private UserService userService;

    @Value("${mail.reminder.message}")
    private String msg;

    @Scheduled(cron = "${mail.reminder.cron}")
    public void sendReminders(){

        List<String> mails = userService.getMails();
        for (String mail : mails) {
             sendMail(mail, msg);
        }
    }

    private void sendMail(String mail, String msg) {
        //dummy code
    }
}
