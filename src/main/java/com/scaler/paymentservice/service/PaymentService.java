package com.scaler.paymentservice.service;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.scaler.paymentservice.paymentGateWay.PaymentGateWay;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService  {
   private final PaymentGateWay paymentGateWay;

   public String initiatePayment(Long orderId,Long amount) throws RazorpayException {
      return paymentGateWay.generatePaymentLink(orderId,amount);
   }
}
