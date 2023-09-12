package com.app.payload.request;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class FavoriteQueryParam {
    Integer id;

    Date favorite_time;
}
