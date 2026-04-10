package com.example.booking_meeting_rooms.Repo;

import com.example.booking_meeting_rooms.Entity.BookingFolder.Booking;
import com.example.booking_meeting_rooms.Entity.BookingFolder.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN TRUE ELSE FALSE END FROM Booking b " +
            "WHERE b.room.id = :roomId AND b.status = 'ACTIVE' " +
            "AND b.startDate <= :endDate AND b.endDate >= :startDate")
    boolean existsConflictingBooking(@Param("roomId") Long roomId,
                                     @Param("startDate") LocalDate startDate,
                                     @Param("endDate") LocalDate endDate);
    @Query("SELECT b FROM Booking b WHERE b.status = :status AND b.endDate < :date")
    List<Booking> findAllByStatusAndEndDateBefore(
            @Param("status") BookingStatus status,
            @Param("date") LocalDate date);


    @Query("SELECT b FROM Booking b JOIN FETCH b.employee WHERE b.id = :bookingId")
    Optional<Booking> findWithEmployee(@Param("bookingId") Long bookingId);
}