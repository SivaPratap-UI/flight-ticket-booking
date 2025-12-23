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





### Steps to Run Application 

- Run from IntelliJ IDEA
- Open the project in IntelliJ
- Ensure Project SDK = Java 17
- Open FlightBookingApplication.java
- Click the Run ▶ button
- Application will start on http://localhost:8080


## Run from Command Line

- cd flight-booking-api
- mvn spring-boot:run

## Build & Run as JAR

- mvn clean package
- java -jar target/flight-booking-api-1.0.0.jar

## Endpoint
### POST /api/bookings

### Example Requests

## Single User Booking

- Request JSON:

{
  "flightNumber": "AI101",
  "seatClass": "BUSINESS",
  "passengers": [
    {
      "firstName": "John",
      "lastName": "Doe",
      "dateOfBirth": "1990-05-10",
      "passportNumber": "P123"
    }
  ]
}

## Family Booking

- Request JSON:

{
  "flightNumber": "AI101",
  "seatClass": "ECONOMY",
  "passengers": [
    {
      "firstName": "John",
      "lastName": "Doe",
      "dateOfBirth": "1985-01-10",
      "passportNumber": "P111"
    },
    {
      "firstName": "Jane",
      "lastName": "Doe",
      "dateOfBirth": "1987-03-20",
      "passportNumber": "P222"
    }
  ]
}

### Response

[
  {
    "bookingId": "f1a8c8c0-7b2c-4a91-b2a6-3c5f7a8b9c01",
    "flightNumber": "AI101",
    "firstName": "John",
    "lastName": "Doe",
    "seatClass": "ECONOMY",
    "passportNumber": "P111",
    "status": "CONFIRMED"
  },
  {
    "bookingId": "a8b9c7f5-3d2e-4c1a-9b0a-8c7d6e5f4a02",
    "flightNumber": "AI101",
    "firstName": "Jane",
    "lastName": "Doe",
    "seatClass": "ECONOMY",
    "passportNumber": "P222",
    "status": "CONFIRMED
]

### what you would improve if you had more time

- Send Email for the confirmation once tickets are booked
- Idempotency Support (Prevent duplicate bookings by supporting idempotency keys)
- Track seat availability per class more precisely
- Selection of meal
- Support booking cancellation and status transitions
- Introduce a standard error response object