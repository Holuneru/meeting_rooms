package com.example.booking_meeting_rooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookingMeetingRoomsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingMeetingRoomsApplication.class, args);
    }

}
