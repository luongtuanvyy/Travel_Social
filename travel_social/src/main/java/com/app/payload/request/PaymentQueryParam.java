package com.app.payload.request;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentQueryParam extends BaseQueryRequest{
    Integer id;

    String name;

    Boolean active;
}
