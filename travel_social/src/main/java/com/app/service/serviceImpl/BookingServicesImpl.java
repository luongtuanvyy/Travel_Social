//package com.app.service.serviceImpl;
//
//import com.app.dto.BookingDto;
//import com.app.entity.Booking;
//import com.app.entity.Payment;
//import com.app.entity.Tour;
//import com.app.mapper.BookingMapper;
//import com.app.payload.response.APIResponse;
//import com.app.payload.response.FailureAPIResponse;
//import com.app.payload.response.SuccessAPIResponse;
//import com.app.service.BookingServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//
//@Service
//public class BookingServicesImpl implements BookingServices {
//    @Autowired
//    AccountRepository accountRepository;
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    BookingMapper bookingMapper;
//    @Autowired
//    private TourRepository tourRepository;
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Transactional(transactionManager = "transactionManager")
//    public APIResponse bookTour(BookingDto bookingRequest) {
//        if (checkAvailability(bookingRequest)) {
//            Booking booking = bookingMapper.toBooking(bookingRequest);
//            booking.setBooking_date(LocalDateTime.now()); // Or use bookingRequest.getBookingDate()
//            booking.setStatus("wait"); // Or use bookingRequest.getStatus()
//            booking.setNote(bookingRequest.getNote());
//            booking.setNumber_of_adult(bookingRequest.getNumberOfAdults());
//            booking.setNumber_of_children(bookingRequest.getNumberOfChildren());
//            booking.setNumber_of_baby(bookingRequest.getNumberOfBabies());
//            booking.setAdult_price(bookingRequest.getAdultPrice());
//            booking.setChildren_price(bookingRequest.getChildrenPrice());
//            booking.setBabby_price(bookingRequest.getBabyPrice());
//            booking.setTotal_price(bookingRequest.getTotalPrice());
////            Users user = userRepository.findById(1);
////            booking.setUser(user);
//            Tour tour = tourRepository.findById(bookingRequest.getTourId()).orElse(null);
//            booking.setTour(tour);
//
//            Payment payment = paymentRepository.findById(bookingRequest.getPaymentId()).orElse(null);
//            booking.setPayment(payment);
//            bookingRepository.save(booking);
//            return new SuccessAPIResponse("Booking successful");
//
//        } else {
//            return new FailureAPIResponse("Tour is not available for booking.");
//        }
//    }
//
//    private boolean checkAvailability(BookingDto bookingRequest) {
//        Tour tour = tourRepository.findById(bookingRequest.getTourId()).orElse(null);
//        if (tour == null) {
//            return false; // Tour not found
//        }
//        int totalParticipants = bookingRequest.getNumberOfAdults() + bookingRequest.getNumberOfChildren() + bookingRequest.getNumberOfBabies();
//        int remainingSlots = tour.getSize() - tour.getREGISTERED();
//        return totalParticipants <= remainingSlots;
//    }
//
//
//}
//
//
//
