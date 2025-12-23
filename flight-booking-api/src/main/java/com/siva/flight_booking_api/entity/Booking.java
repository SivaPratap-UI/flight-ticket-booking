package com.siva.flight_booking_api.entity;

import com.siva.flight_booking_api.enums.SeatClass;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

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

}
