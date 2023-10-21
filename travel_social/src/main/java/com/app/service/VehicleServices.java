package com.app.service;

import com.app.entity.Vehicle;
import com.app.payload.request.VehicalQueryParam;
import com.app.payload.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

public interface VehicleServices {
    APIResponse filterVehicle(VehicalQueryParam vehicalQueryParam);

    APIResponse create(Vehicle vehicle, MultipartFile image);
    APIResponse update(Vehicle vehicle,MultipartFile image);
    APIResponse delete(Integer id);
}
