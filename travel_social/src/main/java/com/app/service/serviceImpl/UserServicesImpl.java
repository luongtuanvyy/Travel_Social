package com.app.service.serviceImpl;


import com.app.entity.Users;
import com.app.payload.request.UserQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.UserRepository;
import com.app.service.UserServices;
import com.app.speficication.UserSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RequestParamsUtils requestParamsUtils;

    @Autowired
    UserSpecification userSpecification;

    @Override
    public Optional<Users> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public APIResponse filterUser(UserQueryParam userQueryParam) {
        Specification<Users> spec = userSpecification.getUserSpecification(userQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(userQueryParam);
        Page<Users> response = userRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }
}
