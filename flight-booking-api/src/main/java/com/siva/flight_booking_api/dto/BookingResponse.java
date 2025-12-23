package com.siva.flight_booking_api.dto;

import com.siva.flight_booking_api.entity.Booking;
import com.siva.flight_booking_api.enums.SeatClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookingResponse {

    private UUID bookingId;
    private String flightNumber;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String status;
    private SeatClass seatClass;

    public BookingResponse(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.flightNumber = booking.getFlightNumber();
        this.firstName = booking.getFirstName();
        this.lastName = booking.getLastName();
        this.passportNumber = booking.getPassportNumber();
        this.status = booking.getStatus();
        this.seatClass = booking.getSeatClass();
    }

}

