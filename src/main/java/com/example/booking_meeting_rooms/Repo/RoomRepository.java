package com.example.booking_meeting_rooms.Repo;

import com.example.booking_meeting_rooms.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}