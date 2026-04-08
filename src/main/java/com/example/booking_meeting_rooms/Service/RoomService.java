package com.example.booking_meeting_rooms.Service;

import com.example.booking_meeting_rooms.DTO.DtoRoom.RoomRequestCreate;
import com.example.booking_meeting_rooms.DTO.DtoRoom.RoomResponse;
import com.example.booking_meeting_rooms.Entity.Room;
import com.example.booking_meeting_rooms.Mapper.RoomMapper.MapperRoom;
import com.example.booking_meeting_rooms.Repo.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final MapperRoom mapperRoom;

    public RoomResponse createRoom(RoomRequestCreate request){
        Room saved = roomRepository.save(mapperRoom.toRoom(request));
        return mapperRoom.toResponse(saved);
    }

    public List<RoomResponse> getAllRooms(){
        return roomRepository.findAll().stream().map(mapperRoom::toResponse).toList();
    }

}
