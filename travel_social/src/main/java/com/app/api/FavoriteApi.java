package com.app.api;

import com.app.payload.request.FavoriteQueryParam;
import com.app.payload.request.FollowQueryParam;
import com.app.service.FavoriteServices;
import com.app.service.FollowServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class FavoriteApi {
    @Autowired
    FavoriteServices favoriteServices;

    @GetMapping("/favorites/filter")
    public ResponseEntity<?> getAllFollow (FavoriteQueryParam favoriteQueryParam) {
        return ResponseEntity.ok(favoriteServices.filterFavorite(favoriteQueryParam));
    }
}
