package com.example.booking_meeting_rooms.Mapper.RoomMapper;

import com.example.booking_meeting_rooms.DTO.DtoRoom.RoomRequestCreate;
import com.example.booking_meeting_rooms.DTO.DtoRoom.RoomResponse;
import com.example.booking_meeting_rooms.Entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperRoom {
    Room toRoom(RoomRequestCreate roomRequestCreate);

    RoomResponse toResponse(Room room);
}
