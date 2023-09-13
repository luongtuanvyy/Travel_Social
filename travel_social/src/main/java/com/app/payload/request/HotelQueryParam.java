package com.app.payload.request;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelQueryParam extends BaseQueryRequest{

    Integer id;

    String name;

    String address;

    Boolean verify;

    Float rating;

    Boolean active;
}
