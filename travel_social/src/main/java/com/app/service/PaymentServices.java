package com.app.service;


import com.app.entity.Booking;
import com.app.entity.Payment;
import com.app.payload.request.PaymentQueryParam;
import com.app.payload.response.APIResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentServices {
    APIResponse filterPayment(PaymentQueryParam paymentQueryParam);

    APIResponse create(Payment payment);
    APIResponse update(Payment payment);
    APIResponse delete(Integer id);
}
