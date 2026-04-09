package com.example.booking_meeting_rooms.DTO.DtoEmployee.GetInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWithBookingDto {
    private String employeeName;
    private List<EmployeeBookingsDto> bookingsListDto = new ArrayList<>();
}
