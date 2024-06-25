package com.scaler.paymentservice.paymentGateWay;

import com.razorpay.RazorpayException;
import org.springframework.stereotype.Component;

@Component
public interface PaymentGateWay {
    public String generatePaymentLink(Long orderId, Long amount) throws RazorpayException;
}
