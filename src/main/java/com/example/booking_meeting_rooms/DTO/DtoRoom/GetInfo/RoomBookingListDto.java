package com.example.booking_meeting_rooms.DTO.DtoRoom.GetInfo;

import com.example.booking_meeting_rooms.Entity.EmployeesFolder.Employee;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookingListDto {

    private String employeeName;      // имя + фамилия
    private LocalDate startDate;
    private LocalDate endDate;
    private String purpose;
}
