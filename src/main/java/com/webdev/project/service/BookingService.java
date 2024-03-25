package com.webdev.project.service;

import com.webdev.project.model.Booking;
import com.webdev.project.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    BookingRepo bookingRepo;

    @Autowired
    public BookingService(BookingRepo repo) {
        super();
        this.bookingRepo =  repo;
    }

    // Service layer includes business logic (user repo to make sure booking isn't already taken etc)
    public Booking createBooking(Booking booking) {
        return new Booking();
    }

}
