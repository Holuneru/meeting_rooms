package com.example.booking_meeting_rooms.Controller.EmployeeController;

import com.example.booking_meeting_rooms.DTO.DtoEmployee.EmployeeRequestCreate;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.EmployeeResponse;
import com.example.booking_meeting_rooms.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping(path = "/registration")
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequestCreate request){
        return employeeService.regEmployee(request);
    }


}

