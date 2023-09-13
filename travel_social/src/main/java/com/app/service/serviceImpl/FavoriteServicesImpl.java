package com.app.service.serviceImpl;
import com.app.entity.Favorite;
import com.app.payload.request.FavoriteQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.FavoriteRepository;
import com.app.service.FavoriteServices;
import com.app.speficication.FavoriteSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServicesImpl implements FavoriteServices {
    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    FavoriteSpecification favoriteSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    CloudinaryService cloudinaryService;

    @Override
    public APIResponse filterFavorite(FavoriteQueryParam favoriteQueryParam) {
        Specification<Favorite> spec = favoriteSpecification.getFavoriteSpecitification(favoriteQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(favoriteQueryParam);
        Page<Favorite> response = favoriteRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
}
