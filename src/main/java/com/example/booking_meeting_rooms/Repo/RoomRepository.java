package com.example.booking_meeting_rooms.Repo;

import com.example.booking_meeting_rooms.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r LEFT JOIN FETCH r.bookingList WHERE r.name = :name")
    Optional<Room> findWithBookings(@Param("name") String name);
}