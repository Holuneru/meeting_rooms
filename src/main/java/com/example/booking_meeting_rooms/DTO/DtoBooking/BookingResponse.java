package com.example.booking_meeting_rooms.DTO.DtoBooking;

import com.example.booking_meeting_rooms.Entity.BookingFolder.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private String room_name;
    private LocalDate startDate;
    private LocalDate endDate;
    private BookingStatus status;
}
