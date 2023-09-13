package com.app.service;

import com.app.payload.request.RestaurantQueryParam;
import com.app.payload.response.APIResponse;

public interface RestaurantServices {
    APIResponse filterRestaurant(RestaurantQueryParam restaurantQueryParam);
}
