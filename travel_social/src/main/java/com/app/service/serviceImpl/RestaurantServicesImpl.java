package com.app.service.serviceImpl;
import com.app.entity.Restaurant;
import com.app.payload.request.RestaurantQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.RestaurantRepository;
import com.app.service.RestaurantServices;
import com.app.speficication.RestaurantSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServicesImpl implements RestaurantServices {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    RestaurantSpecification restaurantSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public APIResponse filterRestaurant(RestaurantQueryParam restaurantQueryParam) {
        Specification<Restaurant> spec = restaurantSpecification.getRestaurantSpecification(restaurantQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(restaurantQueryParam);
        Page<Restaurant> response = restaurantRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
}
