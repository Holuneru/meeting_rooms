package com.example.booking_meeting_rooms.Service;

import com.example.booking_meeting_rooms.DTO.DtoBooking.BookingRequest;
import com.example.booking_meeting_rooms.DTO.DtoBooking.BookingResponse;
import com.example.booking_meeting_rooms.Repo.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingResponse createBooking(BookingRequest request){

    }
}
