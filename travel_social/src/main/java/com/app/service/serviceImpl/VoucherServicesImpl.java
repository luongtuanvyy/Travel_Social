package com.app.service.serviceImpl;
import com.app.entity.TourPrice;
import com.app.entity.View;
import com.app.entity.Voucher;
import com.app.payload.request.VoucherQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.ViewRepository;
import com.app.repository.VoucherRepository;
import com.app.service.VourcherServices;
import com.app.speficication.ViewSpecification;
import com.app.speficication.VourcherSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class VoucherServicesImpl implements VourcherServices {
    @Autowired
    VoucherRepository voucherRepository;
    @Autowired
    VourcherSpecification voucherSpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Override
    public APIResponse filterVoucher(VoucherQueryParam voucherQueryParam) {
        Specification<Voucher> spec = voucherSpecification.getVoucherSpecification(voucherQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(voucherQueryParam);
        Page<Voucher> response = voucherRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }

    @Override
    public APIResponse create(Voucher voucher) {
        voucher = voucherRepository.save(voucher);
        return new SuccessAPIResponse(voucher);
    }

    @Override
    public APIResponse update(Voucher voucher) {
        if (voucher == null) {
            return new FailureAPIResponse("Blog id is required!");
        }
        Voucher exists = voucherRepository.findById(voucher.getId()).orElse(null);
        if (exists == null) {
            return new FailureAPIResponse("Cannot find blog with id: " + voucher.getId());
        }

        voucher = voucherRepository.save(voucher);
        return new SuccessAPIResponse(voucher);
    }

    @Override
    public APIResponse delete(Integer id) {
        try {
            voucherRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}
