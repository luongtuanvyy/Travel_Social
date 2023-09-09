package com.app.mapper;


import com.app.dto.BookingDto;
import com.app.entity.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {


    @Autowired
    ModelMapper modelMapper;
    public Booking toBooking(BookingDto bookingDto) {
        if (bookingDto == null) {
            return null;
        }
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        return booking;
    }
}
