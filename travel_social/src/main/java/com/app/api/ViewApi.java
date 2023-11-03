package com.app.api;

import com.app.entity.Like;
import com.app.entity.View;
import com.app.payload.request.LikeQueryParam;
import com.app.payload.request.ViewQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.LikeServices;
import com.app.service.ViewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class ViewApi {
    @Autowired
    ViewServices viewServices;

    @GetMapping("/view")
    public ResponseEntity<?> filterView(ViewQueryParam viewQueryParam) {
        return ResponseEntity.ok(viewServices.filterView(viewQueryParam));
    }

    @PostMapping("/view")
    public ResponseEntity<?> createView(@RequestPart(name = "view") View view){
        APIResponse response = viewServices.create(view);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/view")
    public ResponseEntity<?> updateView(@RequestPart(name = "view") View view){
        APIResponse response = viewServices.update(view);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/view")
    public ResponseEntity<?> deleteView(@RequestParam("id") Integer id){
        APIResponse response = viewServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
