package com.springboot.security;

import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;

@SpringBootApplication
public class SecutiryApplication implements ApplicationRunner {
    public static final String ACCOUNT_SID = "AC5567ae478377aff090a11c6c9c66f6f8";
    public static final String AUTH_TOKEN = "cc84f6725966ef665472129b963eab52";

    public static void main(String[] args) {
        SpringApplication.run(SecutiryApplication.class, args);
      }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Call.creator(new PhoneNumber("<to-number>"), new PhoneNumber("<from-number>"),
                new URI("http://demo.twilio.com/docs/voice.xml")).create();
    }
}
