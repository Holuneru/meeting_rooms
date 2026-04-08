package com.example.booking_meeting_rooms.DTO.DtoBooking;

import com.example.booking_meeting_rooms.Entity.BookingFolder.BookingStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingResponse {
    private String room_name;
    private LocalDate startTime;
    private LocalDate endTime;
    private BookingStatus status;
}
