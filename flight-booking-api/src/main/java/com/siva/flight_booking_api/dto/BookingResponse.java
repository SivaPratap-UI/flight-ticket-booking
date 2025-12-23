package com.siva.flight_booking_api.dto;

import com.siva.flight_booking_api.entity.Booking;

import java.util.UUID;

public class BookingResponse {

    private UUID bookingId;
    private String flightNumber;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String status;

    public BookingResponse(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.flightNumber = booking.getFlightNumber();
        this.firstName = booking.getFirstName();
        this.lastName = booking.getLastName();
        this.passportNumber = booking.getPassportNumber();
        this.status = booking.getStatus();
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public String getStatus() {
        return status;
    }
}

