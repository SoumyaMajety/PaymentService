package com.scaler.paymentservice.controller;

import com.razorpay.RazorpayException;
import com.scaler.paymentservice.dto.PaymentRequestDto;
import com.scaler.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
     private final PaymentService paymentService;

    @PostMapping("/")
    public ResponseEntity<String> initiatePayment(@RequestBody PaymentRequestDto requestDto)  {
           try {
               String link = paymentService.initiatePayment(requestDto.getOrderId(), requestDto.getAmount());
               return new ResponseEntity<>(link, HttpStatus.OK);
           }
           catch (RazorpayException e){
               return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
           }
    }
}
