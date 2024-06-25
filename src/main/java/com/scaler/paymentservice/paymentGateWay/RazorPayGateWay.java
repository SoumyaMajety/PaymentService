package com.scaler.paymentservice.paymentGateWay;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RazorPayGateWay implements PaymentGateWay{

    private final RazorpayClient razorPayClient;

    @Override
    public String generatePaymentLink(Long orderId, Long amount) throws RazorpayException {

        // ORDER DETAILS
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount); // 1000 - > 10.00
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", 1718188998);
        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description","Payment for orderId " + orderId.toString());


        // CUSTOMER DETAILS
        JSONObject customer = new JSONObject();
        customer.put("name","+919032769261");
        customer.put("contact","soumya majety");
        customer.put("email","majetysoumya80@gmail.com");
        paymentLinkRequest.put("customer",customer);


        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);

        // notify details..
        paymentLinkRequest.put("notify",notify);
//        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
//        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/academy/mentee-dashboard/todos");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink link = razorPayClient.paymentLink.create(paymentLinkRequest);

        return link.toString();
    }
}
