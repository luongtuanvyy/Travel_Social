package com.app.repository;

import com.app.entity.Booking;
import com.app.entity.BookingCancel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingCancelRepository extends JpaRepository<BookingCancel, Integer> {
    Page<BookingCancel> findAll(Specification<BookingCancel> spec, Pageable pageable);

}

