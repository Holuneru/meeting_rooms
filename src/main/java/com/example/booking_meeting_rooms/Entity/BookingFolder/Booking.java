package com.example.booking_meeting_rooms.Entity.BookingFolder;

import com.example.booking_meeting_rooms.Entity.EmployeesFolder.Employee;
import com.example.booking_meeting_rooms.Entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;


    @Column(nullable = false) private LocalDate startDate;
    @Column(nullable = false) private LocalDate endDate;

    private String purpose;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) private BookingStatus status;

//    id (Long)
//
//    room (ManyToOne)
//
//    employee (ManyToOne)
//
//    startTime (LocalDateTime)
//
//    endTime (LocalDateTime)
//
//    purpose (String, цель бронирования)
//
//    status (String: "ACTIVE", "CANCELLED") – можно не использовать, просто удалять, но лучше оставить.
}
