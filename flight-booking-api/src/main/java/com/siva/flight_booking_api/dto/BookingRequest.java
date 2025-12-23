package com.siva.flight_booking_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BookingRequest {

    @NotBlank
    private String flightNumber;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    @Min(1)
    private Integer numberOfSeats;

    private String passportNumber;

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getPassportNumber() {
        return passportNumber;
    }
}

