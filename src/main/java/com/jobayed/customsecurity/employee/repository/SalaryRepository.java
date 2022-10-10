package com.jobayed.customsecurity.employee.repository;

import com.jobayed.customsecurity.employee.dto.SalResultMap;
import com.jobayed.customsecurity.employee.model.Salary;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

    List<SalResultMap> salaryTwoCol();
}
