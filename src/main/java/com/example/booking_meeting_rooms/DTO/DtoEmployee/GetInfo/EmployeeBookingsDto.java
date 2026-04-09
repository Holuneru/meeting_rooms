package com.example.booking_meeting_rooms.DTO.DtoEmployee.GetInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBookingsDto {
    private String roomName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String purpose;
}
