package com.siva.flight_booking_api.config;


import com.siva.flight_booking_api.entity.FlightInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryFlightStore {

    private final Map<String, FlightInfo> flights = new ConcurrentHashMap<>();

    @PostConstruct
    public void loadFlights() {
        flights.put("AI101", new FlightInfo("AI101", 6, 3, 1));
        flights.put("BA202", new FlightInfo("BA202", 10, 4, 2));
        flights.put("LH303", new FlightInfo("LH303", 8, 2, 1));
    }

    public FlightInfo getFlight(String flightNumber) {
        return flights.get(flightNumber);
    }
}
