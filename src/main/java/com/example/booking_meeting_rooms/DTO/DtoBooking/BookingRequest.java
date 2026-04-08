package com.example.booking_meeting_rooms.DTO.DtoBooking;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookingRequest {
    @NotBlank
    private Long room_id;

    @NotBlank
    private String email_employee;

    private String purpose;

}
