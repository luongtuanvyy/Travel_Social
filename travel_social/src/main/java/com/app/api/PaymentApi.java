package com.app.api;

import com.app.entity.Booking;
import com.app.entity.Payment;
import com.app.payload.request.BookingQueryParam;
import com.app.payload.request.PaymentQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.BookingServices;
import com.app.service.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class PaymentApi {
    @Autowired
    PaymentServices paymentServices;

    @GetMapping("/payment")
    public ResponseEntity<?> filterPayment(PaymentQueryParam paymentQueryParam) {
        return ResponseEntity.ok(paymentServices.filterPayment(paymentQueryParam));
    }

    @PostMapping("/payment")
    public ResponseEntity<?> createPayment(@RequestPart(name = "payment") Payment payment){
        APIResponse response = paymentServices.create(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/payment")
    public ResponseEntity<?> updatePayment(@RequestPart(name = "payment") Payment payment){
        APIResponse response = paymentServices.update(payment);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/payment")
    public ResponseEntity<?> deletePayment(@RequestParam("id") Integer id){
        APIResponse response = paymentServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
