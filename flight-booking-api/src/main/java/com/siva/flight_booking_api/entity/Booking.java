package com.siva.flight_booking_api.entity;

import com.siva.flight_booking_api.enums.SeatClass;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    private UUID bookingId;
    private String flightNumber;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer seats;
    private String passportNumber;
    private String status;
    private SeatClass seatClass;

    public Booking(UUID bookingId, String flightNumber, String firstName,
                   String lastName, LocalDate dateOfBirth,
                   Integer seats, String passportNumber, SeatClass seatClass) {

        this.bookingId = bookingId;
        this.flightNumber = flightNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.seats = seats;
        this.passportNumber = passportNumber;
        this.status = "CONFIRMED";
        this.seatClass = seatClass;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getStatus() {
        return status;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }
}
