package com.app.service;

import com.app.entity.Users;
import com.app.payload.request.UserQueryParam;
import com.app.payload.response.APIResponse;

import java.util.Optional;

public interface UserServices {
    Optional<Users> findById(Integer id);
    Optional<Users> findByEmail(String email);
    APIResponse filterUser(UserQueryParam userQueryParam);
    Users save(Users users);
//    APIResponse searchUsersByFullName(String searchKeyword);

}
