package com.app.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserQueryParam extends BaseQueryRequest{
    String name;
    String email;
}
