package com.app.service.serviceImpl;

import com.app.entity.BlogReaction;
import com.app.entity.BookingCancel;
import com.app.payload.request.BlogReactionQueryParam;
import com.app.payload.request.BookingCancelQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.BlogReactionRepository;
import com.app.repository.BookingCancelRepository;
import com.app.service.BlogReactionServices;
import com.app.service.BookingCancelServices;
import com.app.speficication.BlogReactionSpecification;
import com.app.speficication.BookingCancelSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class BlogReactionServiceimpl implements BlogReactionServices {
    @Autowired
    BlogReactionSpecification blogReactionSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    BlogReactionRepository blogReactionRepository;
    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public APIResponse filterBlogReaction(BlogReactionQueryParam blogReactionQueryParam) {
        Specification<BlogReaction> spec = blogReactionSpecification.getBlogReactionSpecitification(blogReactionQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(blogReactionQueryParam);
        Page<BlogReaction> response = blogReactionRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
    @Override
    public APIResponse create(BlogReaction blogReaction) {
        blogReaction = blogReactionRepository.save(blogReaction);
        return new SuccessAPIResponse(blogReaction);
    }

    @Override
    public APIResponse update(BlogReaction blogReaction) {
        if(blogReaction == null){
            return  new FailureAPIResponse("Booking id is required!");
        }
        BlogReaction exists = blogReactionRepository.findById(blogReaction.getId()).orElse(null);
        if(exists == null){
            return  new FailureAPIResponse("Cannot find Booking with id: "+blogReaction.getId());
        }
        blogReaction = blogReactionRepository.save(blogReaction);
        return new SuccessAPIResponse(blogReaction);
    }


    @Override
    public APIResponse delete(Integer id) {
        try {
            blogReactionRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}
