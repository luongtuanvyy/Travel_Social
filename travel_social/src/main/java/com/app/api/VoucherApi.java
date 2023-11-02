package com.app.api;

import com.app.entity.TourPrice;
import com.app.entity.Voucher;
import com.app.payload.request.TourPriceQueryParam;
import com.app.payload.request.VoucherQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.TourPriceServices;
import com.app.service.VourcherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class VoucherApi {
    @Autowired
    VourcherServices vourcherServices;

    @GetMapping("/voucher/filter")
    public ResponseEntity<?> getAllVoucher (VoucherQueryParam voucherQueryParam) {
        return ResponseEntity.ok(vourcherServices.filterVoucher(voucherQueryParam));
    }
    @PostMapping("/voucher")
    public ResponseEntity<?> createVoucher(@RequestPart(name = "voucher") Voucher voucher){
        APIResponse response = vourcherServices.create(voucher);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/voucher")
    public ResponseEntity<?> updateVoucher(@RequestPart(name = "voucher") Voucher voucher){
        APIResponse response = vourcherServices.update(voucher);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/voucher")
    public ResponseEntity<?> deleteVoucher(@RequestParam("id") Integer id){
        APIResponse response = vourcherServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
