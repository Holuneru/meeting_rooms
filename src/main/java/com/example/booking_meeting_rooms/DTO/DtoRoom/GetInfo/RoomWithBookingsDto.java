package com.example.booking_meeting_rooms.DTO.DtoRoom.GetInfo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomWithBookingsDto {
    private String name; //Room_name

    private List<RoomBookingListDto> bookingListDto = new ArrayList<>();

}
