package com.example.booking_meeting_rooms.Controller;

import com.example.booking_meeting_rooms.DTO.DtoBooking.BookingRequest;
import com.example.booking_meeting_rooms.DTO.DtoBooking.BookingResponse;
import com.example.booking_meeting_rooms.DTO.DtoBooking.GetInfo.AllBookingsInSystem;
import com.example.booking_meeting_rooms.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping(path = "/allBookings/admin/{employeeId}")
    public List<AllBookingsInSystem> getAllBookingsInSystem(@PathVariable Long employeeId){
        return bookingService.getAllBookingsInSystem(employeeId);
    }

    @GetMapping(path = "/checkIntervalDateRoom")
    public boolean checkIntervalDateRoom(@RequestParam("startDate") String startDate,
                                         @RequestParam("endDate") String endDate,
                                         @RequestParam("roomId") Long roomId) {
        return bookingService.checkIntervalDateRoom(LocalDate.parse(startDate), LocalDate.parse(endDate), roomId);
    }

    @PostMapping(path = "/create")
    public BookingResponse createBooking(@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }
    
    @PutMapping(path = "/cancel/employee/{employeeId}/booking/{bookingId}")
    public void cancelBooking(@PathVariable Long employeeId, @PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId, employeeId);
    }
}

