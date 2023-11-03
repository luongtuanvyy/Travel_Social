package com.app.payload.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TourCancelQueryParam extends BaseQueryRequest{
         Integer id;
         Integer percent;
         Integer date;
         Integer TOUR_ID;
}
