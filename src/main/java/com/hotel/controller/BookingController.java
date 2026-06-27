package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.hotel.entity.Booking;
import com.hotel.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String test() {
        return "Booking Controller Working!";
    }

    @PostMapping("/add")
    public Booking addBooking(@Valid @RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable("id") Long id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/update/{id}")
    public Booking updateBooking(@PathVariable("id") Long id,
                                 @Valid @RequestBody Booking updatedBooking) {
        return bookingService.updateBooking(id, updatedBooking);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBooking(@PathVariable("id") Long id) {
        bookingService.deleteBooking(id);
        return "Booking Deleted Successfully";
    }
}