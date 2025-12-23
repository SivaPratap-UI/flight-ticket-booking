package com.siva.flight_booking_api.controller;


import com.siva.flight_booking_api.dto.BookingRequest;
import com.siva.flight_booking_api.dto.BookingResponse;
import com.siva.flight_booking_api.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponse bookFlight(@Valid @RequestBody BookingRequest request) {
        return bookingService.bookFlight(request);
    }
}

