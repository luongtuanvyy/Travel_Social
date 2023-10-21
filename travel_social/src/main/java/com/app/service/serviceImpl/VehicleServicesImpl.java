package com.app.service.serviceImpl;

import com.app.entity.Vehicle;
import com.app.payload.request.VehicalQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.CloudinaryResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.VehicalRepository;
import com.app.service.VehicleServices;
import com.app.speficication.VehicalSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VehicleServicesImpl implements VehicleServices {

    @Autowired
    VehicalRepository vehicalRepository;
    @Autowired
    VehicalSpecification vehicalSpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    CloudinaryService cloudinaryService;

    @Override

    public APIResponse filterVehicle(VehicalQueryParam vehicalQueryParam) {
        Specification<Vehicle> spec = vehicalSpecification.getVehicalSpecification(vehicalQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(vehicalQueryParam);
        Page<Vehicle> response = vehicalRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }

    @Override
    public APIResponse create(Vehicle vehicle, MultipartFile image) {
        if (image != null) {
            CloudinaryResponse cloudinaryResponse = cloudinaryService.uploadFile(image, "vehicle");
            vehicle.setCloudinaryId(cloudinaryResponse.getCloudinaryId());
            vehicle.setImage(cloudinaryResponse.getUrl());
        }
        vehicle = vehicalRepository.save(vehicle);
        return new SuccessAPIResponse(vehicle);
    }

    @Override
    public APIResponse update(Vehicle vehicle, MultipartFile image) {
        if (vehicle == null) {
            return new FailureAPIResponse("Blog id is required!");
        }
        Vehicle exists = vehicalRepository.findById(vehicle.getId()).orElse(null);
        if (exists == null) {
            return new FailureAPIResponse("Cannot find blog with id: " + vehicle.getId());
        }
        if (image != null) {
            cloudinaryService.deleteFile(vehicle.getCloudinaryId());
            CloudinaryResponse cloudinaryResponse = cloudinaryService.uploadFile(image, "vehicle");
            vehicle.setCloudinaryId(cloudinaryResponse.getCloudinaryId());
            vehicle.setImage(cloudinaryResponse.getUrl());
        }
        vehicle = vehicalRepository.save(vehicle);
        return new SuccessAPIResponse(vehicle);
    }

    @Override
    public APIResponse delete(Integer id) {
        try {
            vehicalRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}
