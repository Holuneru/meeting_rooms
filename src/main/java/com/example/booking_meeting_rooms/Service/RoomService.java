package com.example.booking_meeting_rooms.Service;

import com.example.booking_meeting_rooms.DTO.DtoRoom.GetInfo.RoomBookingListDto;
import com.example.booking_meeting_rooms.DTO.DtoRoom.GetInfo.RoomWithBookingsDto;
import com.example.booking_meeting_rooms.DTO.DtoRoom.RoomRequestCreate;
import com.example.booking_meeting_rooms.DTO.DtoRoom.RoomResponse;
import com.example.booking_meeting_rooms.Entity.BookingFolder.BookingStatus;
import com.example.booking_meeting_rooms.Entity.EmployeesFolder.Employee;
import com.example.booking_meeting_rooms.Entity.EmployeesFolder.EmployeeRole;
import com.example.booking_meeting_rooms.Entity.Room;
import com.example.booking_meeting_rooms.Mapper.RoomMapper.MapperRoom;
import com.example.booking_meeting_rooms.Repo.EmployeeRepository;
import com.example.booking_meeting_rooms.Repo.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final MapperRoom mapperRoom;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public RoomResponse createRoomOnlyAdmin(RoomRequestCreate request, Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (!employee.getRole().equals(EmployeeRole.ADMIN)) {
            throw new RuntimeException("Only administrators can create rooms.");
        }

        Room saved = roomRepository.save(mapperRoom.toRoom(request));
        return mapperRoom.toResponse(saved);
    }




    public List<RoomResponse> getAllRooms(){
        return roomRepository.findAll().stream().map(mapperRoom::toResponse).toList();
    }


    @Transactional(readOnly = true)
    public RoomWithBookingsDto getRoomWithActiveBookings(String roomName) {
        Room room = roomRepository.findWithBookings(roomName)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        List<RoomBookingListDto> activeBookings = room.getBookingList().stream()
                .filter(b -> b.getStatus() == BookingStatus.ACTIVE)
                .map(b -> new RoomBookingListDto(
                        b.getEmployee().getFirstName() + " " + b.getEmployee().getLastName(),
                        b.getStartDate(),
                        b.getEndDate(),
                        b.getPurpose()
                ))
                .toList();

        RoomWithBookingsDto response = new RoomWithBookingsDto();
        response.setName(room.getName());
        response.setBookingListDto(activeBookings);
        return response;
    }



}
