package com.siva.flight_booking_api.entity;

import com.siva.flight_booking_api.enums.SeatClass;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class FlightInfo {


    private String flightNumber;

    private final Map<SeatClass, Integer> totalSeats = new EnumMap<>(SeatClass.class);
    private final Map<SeatClass, Integer> bookedSeats = new EnumMap<>(SeatClass.class);

    public FlightInfo(String flightNumber,
                  int economySeats,
                  int businessSeats,
                  int premiumSeats) {

        this.flightNumber = flightNumber;

        totalSeats.put(SeatClass.ECONOMY, economySeats);
        totalSeats.put(SeatClass.BUSINESS, businessSeats);
        totalSeats.put(SeatClass.PREMIUM, premiumSeats);

        bookedSeats.put(SeatClass.ECONOMY, 0);
        bookedSeats.put(SeatClass.BUSINESS, 0);
        bookedSeats.put(SeatClass.PREMIUM, 0);
    }

    public synchronized boolean canBook(SeatClass seatClass, int seats) {
        return bookedSeats.get(seatClass) + seats <= totalSeats.get(seatClass);
    }

    public synchronized void bookSeats(SeatClass seatClass, int seats) {
        bookedSeats.put(seatClass, bookedSeats.get(seatClass) + seats);
    }

    public String getFlightNumber() {
        return flightNumber;
    }
}

