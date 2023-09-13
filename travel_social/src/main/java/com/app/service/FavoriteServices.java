package com.app.service;

import com.app.payload.request.FavoriteQueryParam;
import com.app.payload.response.APIResponse;

public interface FavoriteServices {
    APIResponse filterFavorite(FavoriteQueryParam favoriteQueryParam);
}
