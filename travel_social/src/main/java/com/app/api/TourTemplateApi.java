package com.app.api;

import com.app.entity.TourDetail;
import com.app.entity.TourTemplate;
import com.app.payload.request.TourDetailQueryParam;
import com.app.payload.request.TourTemplateQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.TourDetailServices;
import com.app.service.TourTemplateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TourTemplateApi {
    @Autowired
    TourTemplateServices tourTemplateServices;
    @GetMapping("/tourtemplate")
    public ResponseEntity<?> filter(TourTemplateQueryParam tourTemplateQueryParam) {
        return ResponseEntity.ok(tourTemplateServices.filterTourTemplate(tourTemplateQueryParam));
    }
    @PostMapping("/company/tourtemplate")
    public ResponseEntity<?> createTour(@RequestPart(name = "tourTemplate") TourTemplate tourTemplate){
        APIResponse response = tourTemplateServices.create(tourTemplate);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/company/tourtemplate")
    public ResponseEntity<?> updateTour(@RequestPart(name = "tourTemplate") TourTemplate tourTemplate){
        APIResponse response = tourTemplateServices.update(tourTemplate);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/company/tourtemplate")
    public ResponseEntity<?> deleteTour(@RequestParam("id") Integer id){
        APIResponse response = tourTemplateServices.delete(id);
        return ResponseEntity.ok().body(response);
    }
}
