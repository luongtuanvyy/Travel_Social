package com.app.service;

import com.app.payload.request.VoucherQueryParam;
import com.app.payload.response.APIResponse;

public interface VourcherServices {
    APIResponse filterVoucher(VoucherQueryParam voucherQueryParam);
}
