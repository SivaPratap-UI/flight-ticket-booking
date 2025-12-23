package com.siva.flight_booking_api.service;


import com.siva.flight_booking_api.config.InMemoryFlightStore;
import com.siva.flight_booking_api.dto.BookingRequest;
import com.siva.flight_booking_api.dto.BookingResponse;
import com.siva.flight_booking_api.entity.Booking;
import com.siva.flight_booking_api.entity.FlightInfo;
import com.siva.flight_booking_api.exceptions.FlightNotFoundException;
import com.siva.flight_booking_api.exceptions.OverbookingException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    private final InMemoryFlightStore flightStore;

    public BookingService(InMemoryFlightStore flightStore) {
        this.flightStore = flightStore;
    }

    public List<BookingResponse> bookFlight(BookingRequest request) {

        FlightInfo flight = flightStore.getFlight(request.getFlightNumber());
        if (flight == null) {
            throw new FlightNotFoundException("Flight not found");
        }

        int seatsRequested = request.getPassengers().size();

        synchronized (flight) {

            // ✅ Validate seats ONCE for the whole group
            if (!flight.canBook(request.getSeatClass(), seatsRequested)) {
                throw new OverbookingException(
                        "Not enough seats available in " + request.getSeatClass()
                );
            }

            // ✅ Reserve seats once
            flight.bookSeats(request.getSeatClass(), seatsRequested);

            // ✅ Create bookings per passenger
            return request.getPassengers().stream()
                    .map(p -> {
                        Booking booking = new Booking(
                                UUID.randomUUID(),
                                request.getFlightNumber(),
                                p.getFirstName(),
                                p.getLastName(),
                                p.getDateOfBirth(),
                                1,
                                p.getPassportNumber(),
                                request.getSeatClass()
                        );
                        return new BookingResponse(booking);
                    })
                    .toList();
        }
    }


}
