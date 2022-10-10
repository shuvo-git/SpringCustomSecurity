package com.jobayed.customsecurity.employee.repository;

import com.jobayed.customsecurity.employee.model.Designation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<Designation,Long> {
    Page<Designation> findAll(Pageable pageable);
}
