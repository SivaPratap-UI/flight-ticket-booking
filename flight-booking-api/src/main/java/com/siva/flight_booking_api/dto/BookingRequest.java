package com.siva.flight_booking_api.dto;

import com.siva.flight_booking_api.enums.SeatClass;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    @NotBlank
    private String flightNumber;

    @NotNull
    private SeatClass seatClass;

    @NotEmpty
    @Valid
    private List<PassengerRequest> passengers; // ✅ list of users


}
