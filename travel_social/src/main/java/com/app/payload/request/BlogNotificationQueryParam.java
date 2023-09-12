package com.app.payload.request;

import lombok.Builder;
import lombok.Data;

import java.security.Timestamp;

@Data
@Builder
public class BlogNotificationQueryParam {
    Integer id;

    Timestamp create_time;
}
