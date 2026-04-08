package com.example.booking_meeting_rooms.Repo;

import com.example.booking_meeting_rooms.Entity.EmployeesFolder.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}