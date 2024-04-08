package com.webdev.project.service;

import com.webdev.project.model.Booking;
import com.webdev.project.repo.BookingRepo;
import com.webdev.project.repo.ProvidedServiceRepo;
import com.webdev.project.model.ProvidedService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    BookingRepo bookingRepo;
    ProvidedServiceRepo serviceRepo;

    @Autowired
    public BookingService(BookingRepo repo, ProvidedServiceRepo repo2) {
        super();
        this.bookingRepo =  repo;
        this.serviceRepo = repo2;
    }

    // Service layer includes business logic (user repo to make sure booking isn't already taken etc)
    public Booking createBooking(Booking booking) {
        return new Booking();
    }

    public Booking saveOrUpdateBooking(Booking booking, Optional<List<Long>> selectedServiceIds) {
        List<ProvidedService> selectedServices = serviceRepo.findAllById(selectedServiceIds.orElse(Collections.emptyList()));
        booking.setServices(selectedServices);
        for (ProvidedService providedService : selectedServices) {
            providedService.setBooking(booking);
        }
        return bookingRepo.save(booking);
    }

    public List<Booking> getAllBookings() {
        return this.bookingRepo.findAll();
    }

    public void deleteBookingById(Long id) {
        this.bookingRepo.deleteById(id);
    }

    public Booking getBookingById(Long id) {return this.bookingRepo.getReferenceById(id);}

}
