package com.app.payload.request;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentQueryParam {
    Integer id;

    String name;

    Boolean active;
}
