package com.example.booking_meeting_rooms.Entity;

import com.example.booking_meeting_rooms.Entity.BookingFolder.Booking;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 18)
    @Column(unique = true,nullable = false)
    private String name;

    @Positive
    @Max(5)
    @Column(nullable = false)
    private Integer capacity;

    private Boolean hasProjector;

    private Boolean hasWhiteboard;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookingList = new ArrayList<>();

//    capacity (Integer, вместимость)
//
//    hasProjector (Boolean)
//
//    hasWhiteboard (Boolean)

}