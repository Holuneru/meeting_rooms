package com.example.booking_meeting_rooms.Service;

import com.example.booking_meeting_rooms.DTO.DtoBooking.BookingRequest;
import com.example.booking_meeting_rooms.DTO.DtoBooking.BookingResponse;
import com.example.booking_meeting_rooms.Entity.BookingFolder.Booking;
import com.example.booking_meeting_rooms.Entity.BookingFolder.BookingStatus;
import com.example.booking_meeting_rooms.Entity.EmployeesFolder.Employee;
import com.example.booking_meeting_rooms.Entity.EmployeesFolder.EmployeeRole;
import com.example.booking_meeting_rooms.Entity.Room;
import com.example.booking_meeting_rooms.Repo.BookingRepository;
import com.example.booking_meeting_rooms.Repo.EmployeeRepository;
import com.example.booking_meeting_rooms.Repo.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Slf4j
@RequiredArgsConstructor
@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final EmployeeRepository employeeRepository;

    public BookingResponse createBooking(BookingRequest request){
        if (request.getStartDate().isBefore(LocalDate.now())){
            throw new RuntimeException("incorrect StartDate");
        }

        Room room_booking = roomRepository.findById(request.getRoom_id()).orElseThrow(
                () -> new RuntimeException("Room not found")
        );

        Employee employee_booker = employeeRepository.findByEmail(request.getEmail_employee()).orElseThrow(
                () -> new RuntimeException("employee not found")
        );

        boolean checkConflict = bookingRepository.existsConflictingBooking(
                request.getRoom_id(),
                request.getStartDate(),
                request.getStartDate().plusDays(1)
        );
        if (checkConflict){
            throw new RuntimeException("Conflict Booking");
        }
        Booking newBooking = new Booking();
        newBooking.setEmployee(employee_booker);
        newBooking.setRoom(room_booking);
        newBooking.setPurpose(request.getPurpose());
        newBooking.setStartDate(request.getStartDate());
        newBooking.setEndDate(request.getStartDate().plusDays(1));
        newBooking.setStatus(BookingStatus.ACTIVE);
        Booking saved = bookingRepository.save(newBooking);
        log.info("Booking created");
        return new BookingResponse(room_booking.getName(), request.getStartDate(),saved.getEndDate(),saved.getStatus());
    }

    @Transactional
    public void cancelBooking(Long bookingId, Long employeeId) {
        Booking booking = bookingRepository.findWithEmployee(bookingId).orElseThrow(
                () -> new RuntimeException("Booking not found with ID: " + bookingId)
        );
        
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new RuntimeException("Employee not found with ID: " + employeeId)
        );
        
        if (booking.getStatus() == BookingStatus.CANCELLED){
            throw new RuntimeException("Booking already cancelled");
        }
        
        if (employee.getRole() == EmployeeRole.ADMIN){
            booking.setStatus(BookingStatus.CANCELLED);
            bookingRepository.save(booking);
            log.info("Booking with ID: {} cancelled by Admin (Employee ID: {})", bookingId, employeeId);
            return; // Admin can cancel any booking, so exit after cancellation
        }
        
        if (!booking.getEmployee().getId().equals(employee.getId())) {
            throw new RuntimeException("Employee with ID: " + employeeId + " is not authorized to cancel this booking.");
        }
        
        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);
        log.info("Booking with ID: {} cancelled by Employee (ID: {})", bookingId, employeeId);
    }
}
