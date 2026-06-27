package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Booking;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + id));
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + id));

        booking.setCustomer(updatedBooking.getCustomer());
        booking.setRoom(updatedBooking.getRoom());
        booking.setCheckInDate(updatedBooking.getCheckInDate());
        booking.setCheckOutDate(updatedBooking.getCheckOutDate());

        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + id));

        bookingRepository.delete(booking);
    }
}