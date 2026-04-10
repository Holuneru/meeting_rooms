package com.example.booking_meeting_rooms.DTO.DtoEmployee.GetInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeOnlyAdminsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
