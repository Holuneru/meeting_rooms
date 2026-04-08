package com.example.booking_meeting_rooms.Mapper.BookingMapper;

import com.example.booking_meeting_rooms.DTO.DtoBooking.BookingRequest;
import com.example.booking_meeting_rooms.DTO.DtoBooking.BookingResponse;
import com.example.booking_meeting_rooms.Entity.BookingFolder.Booking;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperBooking {
    List<BookingResponse> toResponseList(List<Booking> bookingList);
    Booking toBooking(BookingRequest bookingRequest);
    BookingResponse toBookingResponse(Booking booking);
}
