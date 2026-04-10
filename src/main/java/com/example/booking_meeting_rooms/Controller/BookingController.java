package com.example.booking_meeting_rooms.Controller;

import com.example.booking_meeting_rooms.DTO.DtoBooking.BookingRequest;
import com.example.booking_meeting_rooms.DTO.DtoBooking.BookingResponse;
import com.example.booking_meeting_rooms.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping(path = "/create")
    public BookingResponse createBooking(@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }
    
    @PutMapping(path = "/cancel/employee/{employeeId}/booking/{bookingId}")
    public void cancelBooking(@PathVariable Long employeeId, @PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId, employeeId);
    }
}

