package com.app.service;

import com.app.entity.Favorite;
import com.app.entity.Follow;
import com.app.payload.request.FavoriteQueryParam;
import com.app.payload.response.APIResponse;

public interface FavoriteServices {
    APIResponse filterFavorite(FavoriteQueryParam favoriteQueryParam);
    APIResponse create(Favorite favorite);
    APIResponse update(Favorite favorite);
    APIResponse delete(Integer id);
}
