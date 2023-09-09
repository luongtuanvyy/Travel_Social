package com.app.payload.request;

import lombok.Data;

@Data
public class BaseQueryRequest {
    int page = 0;
    int pageSize = 12;
    String orderBy = "asc";
    String sortFiled = "id";
}
