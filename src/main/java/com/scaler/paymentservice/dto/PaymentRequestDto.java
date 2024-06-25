package com.scaler.paymentservice.dto;

import lombok.Data;

@Data
public class PaymentRequestDto {
  private   Long orderId;
   private Long amount;
}
