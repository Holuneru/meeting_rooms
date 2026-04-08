package com.example.booking_meeting_rooms.Mapper.EmployeeMapper;

import com.example.booking_meeting_rooms.DTO.DtoEmployee.EmployeeRequestCreate;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.EmployeeResponse;
import com.example.booking_meeting_rooms.Entity.EmployeesFolder.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperEmployee {
    Employee toEmployee(EmployeeRequestCreate employeeRequestCreate);
    EmployeeResponse toEmployeeResponse(Employee employee);
}
