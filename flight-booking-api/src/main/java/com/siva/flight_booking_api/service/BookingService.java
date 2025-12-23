package com.siva.flight_booking_api.service;


import com.siva.flight_booking_api.config.InMemoryFlightStore;
import com.siva.flight_booking_api.dto.BookingRequest;
import com.siva.flight_booking_api.dto.BookingResponse;
import com.siva.flight_booking_api.entity.Booking;
import com.siva.flight_booking_api.entity.FlightInfo;
import com.siva.flight_booking_api.exceptions.FlightNotFoundException;
import com.siva.flight_booking_api.exceptions.OverbookingException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

    private final InMemoryFlightStore flightStore;

    public BookingService(InMemoryFlightStore flightStore) {
        this.flightStore = flightStore;
    }

    public BookingResponse bookFlight(BookingRequest request) {

        FlightInfo flight = flightStore.getFlight(request.getFlightNumber());
        if (flight == null) {
            throw new FlightNotFoundException("Flight not found");
        }

        synchronized (flight) {
            if (!flight.canBook(request.getSeatClass(), request.getNumberOfSeats())) {
                throw new OverbookingException(
                        "Not enough seats available in " + request.getSeatClass()
                );
            }

            flight.bookSeats(
                    request.getSeatClass(),
                    request.getNumberOfSeats()
            );
        }

        Booking booking = new Booking(
                UUID.randomUUID(),
                request.getFlightNumber(),
                request.getFirstName(),
                request.getLastName(),
                request.getDateOfBirth(),
                request.getNumberOfSeats(),
                request.getPassportNumber(),
                request.getSeatClass()

        );

        return new BookingResponse(booking);
    }

}
