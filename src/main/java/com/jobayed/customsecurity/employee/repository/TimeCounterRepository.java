package com.jobayed.customsecurity.employee.repository;

import com.jobayed.customsecurity.employee.model.TimeCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimeCounterRepository extends JpaRepository<TimeCounter, Long> {
    Optional<TimeCounter> findByEmployeeId(String employeeId);
}
