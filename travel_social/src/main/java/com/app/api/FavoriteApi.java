package com.app.api;

import com.app.entity.Favorite;
import com.app.entity.Follow;
import com.app.payload.request.FavoriteQueryParam;
import com.app.payload.request.FollowQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.FavoriteServices;
import com.app.service.FollowServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class FavoriteApi {
    @Autowired
    FavoriteServices favoriteServices;

    @GetMapping("/favorites/filter")
    public ResponseEntity<?> getAllFavorite (FavoriteQueryParam favoriteQueryParam) {
        return ResponseEntity.ok(favoriteServices.filterFavorite(favoriteQueryParam));
    }
    @PostMapping("/favorites")
    public ResponseEntity<?> createFavorite(@RequestPart(name = "favorite") Favorite favorite){
        APIResponse response = favoriteServices.create(favorite);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/favorites")
    public ResponseEntity<?> updateFavorite(@RequestPart(name = "favorite") Favorite favorite){
        APIResponse response = favoriteServices.update(favorite);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/favorites")
    public ResponseEntity<?> deleteFavorite(@RequestParam("id") Integer id){
        APIResponse response = favoriteServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
