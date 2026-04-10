package com.example.booking_meeting_rooms.DTO.DtoBooking.GetInfo;

import com.example.booking_meeting_rooms.Entity.BookingFolder.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllBookingsInSystem {
    private Long id;
    private String roomName;
    private String employeeName;
    private String purpose;
    private LocalDate startDate;
    private LocalDate endDate;
    private BookingStatus status;
}
