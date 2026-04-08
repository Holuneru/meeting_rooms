package com.example.booking_meeting_rooms.DTO.DtoRoom;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoomRequestCreate {
    @NotBlank
    @Size(min = 5, max = 18)
    private String name;

    @Positive
    @Max(5)
    private Integer capacity;

    private Boolean hasProjector;

    private Boolean hasWhiteboard;
}
