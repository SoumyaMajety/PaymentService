package com.scaler.paymentservice.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {
    @Value("${razorpay.key.id}")
    public String razorpayId;
    @Value("${razorpay.key.secret}")
    public String secretKey;

    @Bean
    public RazorpayClient getRazorPayClient() throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(razorpayId, secretKey);
        return razorpay;
    }

}
