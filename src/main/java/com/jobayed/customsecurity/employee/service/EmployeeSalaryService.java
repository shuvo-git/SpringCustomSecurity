package com.jobayed.customsecurity.employee.service;


import com.jobayed.customsecurity.employee.model.Salary;
import com.jobayed.customsecurity.baserepository.IBaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeSalaryService {
    private final IBaseRepository repository;

    public Salary getSalaryById(Long id){
        return repository.findByIdLazy(Salary.class,id);
    }
    public Collection<Salary> getAllSalary(){
        return repository.getAllByNamedNAtiveQuery( "highestSalary" ,Salary.class);
    }


}
