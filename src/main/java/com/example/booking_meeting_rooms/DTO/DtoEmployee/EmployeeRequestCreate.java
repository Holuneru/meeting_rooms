package com.example.booking_meeting_rooms.DTO.DtoEmployee;

import com.example.booking_meeting_rooms.Entity.EmployeesFolder.EmployeeRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeRequestCreate {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

}
