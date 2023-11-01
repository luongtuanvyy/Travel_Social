package com.app.service.serviceImpl;

import com.app.entity.Follow;
import com.app.entity.Hotel;
import com.app.payload.request.FollowQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.CloudinaryResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.FollowRepository;
import com.app.service.FollowServices;
import com.app.speficication.FollowSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FollowServicesImpl implements FollowServices {
    @Autowired
    FollowRepository followRepository;
    @Autowired
    FollowSpecification followSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public APIResponse filterFollow(FollowQueryParam followQueryParam) {
        Specification<Follow> spec = followSpecification.getFollowSpecitification(followQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(followQueryParam);
        Page<Follow> response = followRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }

    @Override
    public APIResponse create(Follow follow) {
        follow = followRepository.save(follow);
        return new SuccessAPIResponse(follow);
    }

    @Override
    public APIResponse update(Follow follow) {
        if (follow == null) {
            return new FailureAPIResponse("Blog id is required!");
        }
        Follow exists = followRepository.findById(follow.getId()).orElse(null);
        if (exists == null) {
            return new FailureAPIResponse("Cannot find blog with id: " + follow.getId());
        }

        follow = followRepository.save(follow);
        return new SuccessAPIResponse(follow);
    }

    @Override
    public APIResponse delete(Integer id) {
        try {
            followRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}
