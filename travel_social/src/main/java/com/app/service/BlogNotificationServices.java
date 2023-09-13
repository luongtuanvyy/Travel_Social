package com.app.service;

import com.app.entity.BlogNotification;
import com.app.payload.request.BlogNotificationQueryParam;
import com.app.payload.response.APIResponse;

import java.util.List;

public interface BlogNotificationServices {

    APIResponse filterBlogNotification(BlogNotificationQueryParam blogQueryParam);
}
