package com.app.service.serviceImpl;


import com.app.entity.Tour;
import com.app.payload.request.TourQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.CloudinaryResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.TourRepository;
import com.app.service.TourServices;
import com.app.speficication.TourSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TourServicesImpl implements TourServices {
    @Autowired
    TourRepository tourRepository;

    @Autowired
    RequestParamsUtils requestParamsUtils;

    @Autowired
    TourSpecification tourSpecification;

    @Autowired
    CloudinaryService cloudinaryService;
//    @Override
//    public List<Users> findAll() {
//        return userRepository.findAll();
//    }

//    @Override
//    public List<Users> searchUsersByFullName(String searchKeyword) {
//        // Xử lý trước từ khóa tìm kiếm để loại bỏ dấu và chuyển thành chữ thường
//        String processedKeyword = userRepository.removeDiacritics(searchKeyword.toLowerCase());
//        return userRepository.findByFullNameIgnoreCaseContaining(processedKeyword);
//    }

    public APIResponse filterTour(TourQueryParam tourQueryParam) {
        Specification<Tour> spec = tourSpecification.getTourSpecification(tourQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(tourQueryParam);
        Page<Tour> response = tourRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }


    @Override
    public APIResponse create(Tour tour, MultipartFile image) {
        if (image != null) {
            CloudinaryResponse cloudinaryResponse = cloudinaryService.uploadFile(image, "tour");
            tour.setCloudinaryId(cloudinaryResponse.getCloudinaryId());
            tour.setImage(cloudinaryResponse.getUrl());
        }
        tour = tourRepository.save(tour);
        return new SuccessAPIResponse(tour);
    }

    @Override
    public APIResponse update(Tour tour, MultipartFile image) {
        if(tour == null){
            return  new FailureAPIResponse("tour id is required!");
        }
        Tour exists = tourRepository.findById(tour.getId()).orElse(null);
        if(exists == null){
            return  new FailureAPIResponse("Cannot find product with id: "+tour.getId());
        }
        if (image != null) {
            cloudinaryService.deleteFile(tour.getCloudinaryId());
            CloudinaryResponse cloudinaryResponse = cloudinaryService.uploadFile(image, "tour");
            tour.setCloudinaryId(cloudinaryResponse.getCloudinaryId());
            tour.setImage(cloudinaryResponse.getUrl());
        }
        tour = tourRepository.save(tour);
        return new SuccessAPIResponse(tour);
    }

    @Override
    public APIResponse delete(Integer id) {
        try {
            tourRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }


}
