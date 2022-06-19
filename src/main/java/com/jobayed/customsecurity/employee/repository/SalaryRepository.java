package com.jobayed.customsecurity.employee.repository;

import com.jobayed.customsecurity.employee.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
