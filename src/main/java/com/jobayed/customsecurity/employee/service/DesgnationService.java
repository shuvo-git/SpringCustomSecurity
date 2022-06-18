package com.jobayed.customsecurity.employee.service;

import com.jobayed.customsecurity.employee.model.Designation;
import com.jobayed.customsecurity.employee.repository.DesignationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DesgnationService {
    private final DesignationRepository repository;

    public Designation create(Designation designation){
        log.info("[Saving Designation] - "+designation.getDesignationId() +" ...");
        return repository.save(designation);
    }

    public Designation get(Long id){
        log.info("[Retrieving Designation by ID] - "+id +" ...");
        return repository.findById(id).orElse(null);
    }
}
