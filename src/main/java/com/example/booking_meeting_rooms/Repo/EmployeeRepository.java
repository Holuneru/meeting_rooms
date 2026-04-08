package com.example.booking_meeting_rooms.Repo;

import com.example.booking_meeting_rooms.Entity.EmployeesFolder.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where  e.email = :email")
    Optional<Employee> findByEmail(@Param("email") String email);
}