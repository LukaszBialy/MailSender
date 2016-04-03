package com.white.tech;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailSenderApplication  implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication.run(EmailSenderApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println(applicationArguments);
    }
}
