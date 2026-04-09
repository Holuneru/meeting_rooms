package com.example.booking_meeting_rooms.Service.Shedules;

import com.example.booking_meeting_rooms.Entity.BookingFolder.Booking;
import com.example.booking_meeting_rooms.Entity.BookingFolder.BookingStatus;
import com.example.booking_meeting_rooms.Repo.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class BookingStatusUpdater {

    private final BookingRepository bookingRepository;


    // Запускать каждый день в 00:01
    @Scheduled(cron = "0 1 0 * * *")
    @Transactional
    public void expirePastBookings() {
        LocalDate today = LocalDate.now();
        List<Booking> activeBookings = bookingRepository.findAllByStatusAndEndDateBefore(BookingStatus.ACTIVE, today);

        if (activeBookings.isEmpty()) {
            log.info("No bookings to expire");
            return;
        }

        for (Booking booking : activeBookings) {
            booking.setStatus(BookingStatus.EXPIRED);
            log.info("Booking id={} expired (endDate was {})", booking.getId(), booking.getEndDate());
        }

        bookingRepository.saveAll(activeBookings);
        log.info("Expired {} bookings", activeBookings.size());
    }
}


