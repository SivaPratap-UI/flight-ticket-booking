package com.siva.flight_booking_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightInfo {

    @Id
    private String flightNumber;
    private int totalSeats;
    private int bookedSeats;

    public FlightInfo(String flightNumber, int totalSeats) {
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public synchronized boolean canBook(int seats) {
        return bookedSeats + seats <= totalSeats;
    }

    public synchronized void bookSeats(int seats) {
        this.bookedSeats += seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
}

