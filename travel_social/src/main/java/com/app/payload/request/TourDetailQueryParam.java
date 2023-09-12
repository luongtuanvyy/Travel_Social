package com.app.payload.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TourDetailQueryParam extends BaseQueryRequest{

    Integer id;

    Date dates;

    Date times;
}
