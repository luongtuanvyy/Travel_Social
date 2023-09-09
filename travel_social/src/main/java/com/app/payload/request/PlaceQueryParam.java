package com.app.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceQueryParam extends BaseQueryRequest {
    Integer id;
    String place_name;
    String place_address;
}
