package com.webdev.project.controller;

import com.webdev.project.service.ProvidedServiceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webdev.project.model.Booking;
import com.webdev.project.model.ProvidedService;
import com.webdev.project.service.BookingService;
import com.webdev.project.service.CustomerService;
import com.webdev.project.service.RoomService;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    BookingService bookingService;
    CustomerService customerService;
    RoomService roomService;
    ProvidedServiceService serviceService;

    @Autowired
    public BookingController(BookingService bookingService, CustomerService customerService, RoomService roomService, ProvidedServiceService serviceService) {
        super();
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.roomService = roomService;
        this.serviceService = serviceService;
    }

    @GetMapping("/list")
    public String viewBookings(Model model) {
        model.addAttribute("bookings", this.bookingService.getAllBookings());
        System.out.println(this.bookingService.getAllBookings());
        return "/bookings/list";
    }

    @GetMapping("/create")
    public String viewCreateBooking(Model model) {
        model.addAttribute("newBooking", new Booking());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("rooms", roomService.getAllRooms());

        List<ProvidedService> availableServices = new ArrayList<>();
        for(ProvidedService service: serviceService.getAllServices()) {
            if(null == service.getBooking()) {
                availableServices.add(service);
            }
        }
        

        model.addAttribute("services", availableServices);
        return "/bookings/create";
    }

    @PostMapping("/create")
    public String createBooking(@ModelAttribute("newBooking") Booking newBooking, @RequestParam("selectedServices") Optional<List<Long>> selectedServiceIds, Model model) {
        this.bookingService.saveOrUpdateBooking(newBooking, selectedServiceIds);
        return "redirect:/bookings/list";
    }

    @PostMapping("/delete")
    public String deleteBooking(Long bookingId, Model model) {
        this.bookingService.deleteBookingById(bookingId);
        return "redirect:/bookings/list";
    }

    @GetMapping("/edit/{id}")
    public String viewEditBooking(@PathVariable Long id, Model model) {
        Booking booking = this.bookingService.getBookingById(id);
        System.out.println(booking);
        model.addAttribute("selectedBooking", booking);
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("rooms", roomService.getAllRooms());
        List<ProvidedService> availableServices = new ArrayList<>();
        for(ProvidedService service: serviceService.getAllServices()) {
            if(null == service.getBooking() || service.getBooking().getId() == booking.getId()) {
                availableServices.add(service);
            }
        }
        

        model.addAttribute("services", availableServices);
        return "/bookings/edit";
    }

    @PostMapping("/update")
    public String updateBooking(@ModelAttribute("selectedBooking") Booking booking, @RequestParam("selectedServices") Optional<List<Long>> selectedServiceIds, Model model) {
        this.bookingService.saveOrUpdateBooking(booking, selectedServiceIds);
        return "redirect:/bookings/list";
    }

}
