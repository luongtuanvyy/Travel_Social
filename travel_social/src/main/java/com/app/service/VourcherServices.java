package com.app.service;

import com.app.entity.TourPrice;
import com.app.entity.Voucher;
import com.app.payload.request.VoucherQueryParam;
import com.app.payload.response.APIResponse;

public interface VourcherServices {
    APIResponse filterVoucher(VoucherQueryParam voucherQueryParam);
    APIResponse create(Voucher voucher);
    APIResponse update(Voucher voucher);
    APIResponse delete(Integer id);
}
