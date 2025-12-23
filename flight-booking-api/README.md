# flight-ticket-booking

# Flight Ticket Booking API

Spring Boot REST API for booking flight tickets.

## Tech Stack
- Java 17
- Spring Boot 3.x
- Maven
- In-memory storage (thread-safe)

## Features
- Book flight tickets
- Prevent overbooking
- UUID-based booking ID
- Global error handling
- Clean layered architecture

## Endpoint

### POST /api/bookings

Request:
```json
{
  "flightNumber": "AI101",
  "firstName": "John",
  "lastName": "Doe",
  "dateOfBirth": "1990-05-10",
  "numberOfSeats": 2,
  "passportNumber": "P123456"
}
