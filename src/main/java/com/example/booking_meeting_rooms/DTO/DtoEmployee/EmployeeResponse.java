package com.example.booking_meeting_rooms.DTO.DtoEmployee;

import com.example.booking_meeting_rooms.Entity.BookingFolder.Booking;
import com.example.booking_meeting_rooms.Entity.EmployeesFolder.EmployeeRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeResponse {
    private String firstName;
    private String LastName;
    private EmployeeRole role;
    private List<Booking> bookingList;
}
