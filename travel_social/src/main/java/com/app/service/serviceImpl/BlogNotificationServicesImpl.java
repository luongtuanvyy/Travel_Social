package com.app.service.serviceImpl;

import com.app.entity.BlogNotification;
import com.app.entity.Favorite;
import com.app.payload.request.BlogNotificationQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.BlogNotificationRepository;
import com.app.service.BlogNotificationServices;
import com.app.service.BlogServices;
import com.app.speficication.BlogNotificationSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class BlogNotificationServicesImpl implements BlogNotificationServices {
    @Autowired
    BlogNotificationRepository blogNotificationRepository;
    @Autowired
    BlogNotificationSpecification blogNotificationSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public APIResponse filterBlogNotification(BlogNotificationQueryParam blogNotificationQueryParam) {
        Specification<BlogNotification> spec = blogNotificationSpecification.getAccountSpecification(blogNotificationQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(blogNotificationQueryParam);
        Page<BlogNotification> response = blogNotificationRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }

    @Override
    public APIResponse create(BlogNotification blogNotification) {
        blogNotification = blogNotificationRepository.save(blogNotification);
        return new SuccessAPIResponse(blogNotification);
    }

    @Override
    public APIResponse update(BlogNotification blogNotification) {
        if (blogNotification == null) {
            return new FailureAPIResponse("Blog id is required!");
        }
        BlogNotification exists = blogNotificationRepository.findById(blogNotification.getId()).orElse(null);
        if (exists == null) {
            return new FailureAPIResponse("Cannot find blog with id: " + blogNotification.getId());
        }

        blogNotification = blogNotificationRepository.save(blogNotification);
        return new SuccessAPIResponse(blogNotification);
    }

    @Override
    public APIResponse delete(Integer id) {
        try {
            blogNotificationRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }

}
