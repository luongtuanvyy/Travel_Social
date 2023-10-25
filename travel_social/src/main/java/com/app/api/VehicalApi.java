package com.app.api;

import com.app.payload.request.VehicalQueryParam;
import com.app.service.VehicalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class VehicalApi {
    @Autowired
    VehicalServices vehicalServices;

    @GetMapping("/vehicals")
    public ResponseEntity<?> filter(VehicalQueryParam vehicalQueryParam) {
        return ResponseEntity.ok(vehicalServices.filterVehical(vehicalQueryParam));
    }

}
