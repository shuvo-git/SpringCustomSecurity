package com.jobayed.customsecurity.employee.service;


import com.jobayed.customsecurity.employee.dto.SalResultMap;
import com.jobayed.customsecurity.employee.model.Salary;
import com.jobayed.customsecurity.baserepository.IBaseRepository;
import com.jobayed.customsecurity.employee.repository.SalaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeSalaryService {
    private final IBaseRepository repository;
    private final SalaryRepository salaryRepository;

    public Salary getSalaryById(Long id){
        return repository.findByIdLazy(Salary.class,id);
    }
    public Collection<Salary> getAllSalary(){
        return repository.getAllByNamedNAtiveQuery( "highestSalary" ,Salary.class);
    }

    public Collection<SalResultMap> getAllSalaryTwoCol(){
        //return repository.getAllByNamedNAtiveQuery( "salaryTwoCol" ,SalResultMap.class);
        return salaryRepository.salaryTwoCol();
    }


}
