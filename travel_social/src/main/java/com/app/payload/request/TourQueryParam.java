package com.app.payload.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class TourQueryParam extends BaseQueryRequest {
    BigDecimal minPrice;
    BigDecimal maxPrice;
    Integer id;
    String name;
    String address;
    String vehical;
    String depature;
    Boolean sortRegistered;
    LocalDate start_date;
}
