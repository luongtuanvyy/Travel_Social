package com.app.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicalQueryParam extends BaseQueryRequest{
    Integer id;

    String name;

    Boolean active;

    Boolean verify;
}
