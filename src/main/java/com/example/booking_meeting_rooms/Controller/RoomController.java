package com.example.booking_meeting_rooms.Controller;

import com.example.booking_meeting_rooms.DTO.DtoRoom.RoomRequestCreate;
import com.example.booking_meeting_rooms.DTO.DtoRoom.RoomResponse;
import com.example.booking_meeting_rooms.Service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;


    @GetMapping()
    public List<RoomResponse> getRoomList() {
        return roomService.getAllRooms();
    }

    @PostMapping(path = "/create")
    public RoomResponse createRoom(@Valid @RequestBody RoomRequestCreate request){
        return roomService.createRoom(request);
    }

}

