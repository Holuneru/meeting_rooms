package com.example.booking_meeting_rooms.Service;

import com.example.booking_meeting_rooms.DTO.DtoEmployee.EmployeeRequestCreate;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.EmployeeResponse;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.GetInfo.EmployeeBookingsDto;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.GetInfo.EmployeeOnlyAdminsDto;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.GetInfo.EmployeeWithBookingDto;
import com.example.booking_meeting_rooms.Entity.BookingFolder.BookingStatus;
import com.example.booking_meeting_rooms.Entity.EmployeesFolder.Employee;
import com.example.booking_meeting_rooms.Entity.EmployeesFolder.EmployeeRole;
import com.example.booking_meeting_rooms.Mapper.EmployeeMapper.MapperEmployee;
import com.example.booking_meeting_rooms.Repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final MapperEmployee mapperEmployee;

    public EmployeeResponse regEmployee(EmployeeRequestCreate request){
        Employee employee = mapperEmployee.toEmployee(request);
        employee.setRole(EmployeeRole.USER);
        Employee saved = employeeRepository.save(employee);
        log.info("Employee saved by email: {}", request.getEmail());
        return mapperEmployee.toEmployeeResponse(saved);
    }

    @Transactional(readOnly = true)
    public EmployeeWithBookingDto getEmployeeActiveBookings(Long idEmployee){
        Employee employee = employeeRepository.findWithBookings(idEmployee).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
        List<EmployeeBookingsDto> employeeBookingsDto = employee.getBookingList().stream()
                .filter(b -> b.getStatus() == BookingStatus.ACTIVE)
                .map(b -> new EmployeeBookingsDto(
                        b.getRoom().getName(),
                        b.getStartDate(),
                        b.getEndDate(),
                        b.getPurpose()
                ))
                .toList();
        return new EmployeeWithBookingDto(
                employee.getFirstName() +" "+employee.getLastName(),
                employeeBookingsDto
                );
    }

    public void setAdminStatus(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
        if (employee.getRole() == EmployeeRole.ADMIN){
            throw new RuntimeException("Employee already admin");
        }
        employee.setRole(EmployeeRole.ADMIN);
        employeeRepository.save(employee);
        log.info("Admin status set for employee with ID: {}", employeeId);
    }

    @Transactional(readOnly = true)
    public List<EmployeeOnlyAdminsDto> getEmployeeOnlyAdmins(){

        List<Employee> employees = employeeRepository.findOnlyAdmin();
        return employees.stream()
                .map(e -> new EmployeeOnlyAdminsDto(
                        e.getId(),
                        e.getFirstName(),
                        e.getLastName(),
                        e.getEmail()
                ))
                .toList();

    }
}
