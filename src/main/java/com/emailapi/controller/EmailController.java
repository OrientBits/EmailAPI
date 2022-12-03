package com.emailapi.controller;

import com.emailapi.model.EmailRequest;
import com.emailapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {


    @Autowired
    private EmailService emailService;

    @GetMapping("/welcome")
    public String welcome(){ 
        return "Hello this is smy email api";
    }


    // api to send email
    @PostMapping("/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
        //this.emailService.sendEmail("")
        System.out.println("Request "+request);
        Boolean aBoolean = this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());

        if (aBoolean) {
            return ResponseEntity.ok("Email is send successfully...");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent...");
        }
    }



}
