package com.webdev.project.controller;

import com.webdev.project.service.ProvidedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webdev.project.model.Booking;
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
        return "/bookings/list";
    }

    @GetMapping("/create")
    public String viewCreateBooking(Model model) {
        model.addAttribute("newBooking", new Booking());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("services", serviceService.getAllServices());
        return "/bookings/create";
    }

    @PostMapping("/create")
    public String createBooking(Booking newBooking, Model model) {
        this.bookingService.saveOrUpdateBooking(newBooking);
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
        model.addAttribute("services", serviceService.getAllServices());
        return "/bookings/edit";
    }

    @PostMapping("/update")
    public String updateBooking(Booking booking, Model model) {
        this.bookingService.saveOrUpdateBooking(booking);
        return "redirect:/bookings/list";
    }

}
