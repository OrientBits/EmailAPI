package com.emailapi.controller;

import com.emailapi.model.EmailRequest;
import com.emailapi.model.EmailResponse;
import com.emailapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
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
            return ResponseEntity.ok(new EmailResponse("Email is send successfully..."));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not sent..."));
        }
    }



}
