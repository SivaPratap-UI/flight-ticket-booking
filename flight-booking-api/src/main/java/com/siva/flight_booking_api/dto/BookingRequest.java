package com.siva.flight_booking_api.dto;

import com.siva.flight_booking_api.enums.SeatClass;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class BookingRequest {

    @NotBlank
    private String flightNumber;

    @NotNull
    private SeatClass seatClass;

    @NotEmpty
    @Valid
    private List<PassengerRequest> passengers; // ✅ list of users

    public String getFlightNumber() {
        return flightNumber;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public List<PassengerRequest> getPassengers() {
        return passengers;
    }
}
