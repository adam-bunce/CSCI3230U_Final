package com.webdev.project.service;

import com.webdev.project.model.Booking;
import com.webdev.project.repo.BookingRepo;

import java.util.List;

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

    public Booking saveOrUpdateBooking(Booking booking) {
        System.out.println(booking);
        return this.bookingRepo.save(booking);
    }

    public List<Booking> getAllBookings() {
        return this.bookingRepo.findAll();
    }

    public void deleteBookingById(Long id) {
        this.bookingRepo.deleteById(id);
    }

    public Booking getBookingById(Long id) {return this.bookingRepo.getReferenceById(id);}

}
