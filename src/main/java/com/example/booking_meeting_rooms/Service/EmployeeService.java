package com.example.booking_meeting_rooms.Service;

import com.example.booking_meeting_rooms.DTO.DtoEmployee.EmployeeRequestCreate;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.EmployeeResponse;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.GetInfo.EmployeeBookingsDto;
import com.example.booking_meeting_rooms.DTO.DtoEmployee.GetInfo.EmployeeWithBookingDto;
import com.example.booking_meeting_rooms.Entity.BookingFolder.BookingStatus;
import com.example.booking_meeting_rooms.Entity.EmployeesFolder.Employee;
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

        Employee saved = employeeRepository.save(mapperEmployee.toEmployee(request));
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



}
