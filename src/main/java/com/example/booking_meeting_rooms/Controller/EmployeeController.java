package com.example.booking_meeting_rooms.Controller;

import com.example.booking_meeting_rooms.DTO.DtoEmployee.EmployeeRequestCreate;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.EmployeeResponse;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.GetInfo.EmployeeOnlyAdminsDto;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.GetInfo.EmployeeWithBookingDto;
import com.example.booking_meeting_rooms.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(path = "/{id}/bookings")
    public EmployeeWithBookingDto getEmployeeActiveBookings(@PathVariable Long id) {
        return employeeService.getEmployeeActiveBookings(id);
    }

    @GetMapping(path = "/admins")
    public List<EmployeeOnlyAdminsDto> getEmployeeOnlyAdmins(){
        return employeeService.getEmployeeOnlyAdmins();
    }


    @PostMapping(path = "/registration")
    public EmployeeResponse createEmployee(@Valid @RequestBody EmployeeRequestCreate request){
        return employeeService.regEmployee(request);
    }

    @PutMapping(path = "/{id}/setAdmin")
    public void setAdminStatus(@PathVariable Long id){
        employeeService.setAdminStatus(id);
    }



}

