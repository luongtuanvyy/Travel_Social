package com.app.service;


import com.app.payload.request.PaymentQueryParam;
import com.app.payload.response.APIResponse;

public interface PaymentServices {
    APIResponse filterPayment(PaymentQueryParam paymentQueryParam);
}
