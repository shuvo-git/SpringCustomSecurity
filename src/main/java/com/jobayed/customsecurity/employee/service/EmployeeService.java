package com.jobayed.customsecurity.employee.service;

import com.jobayed.customsecurity.baserepository.IBaseRepository;
import com.jobayed.customsecurity.employee.model.Designation;
import com.jobayed.customsecurity.employee.model.Employee;
import com.jobayed.customsecurity.employee.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

    private final IBaseRepository repository;
    private final DesignationRepository designationRepository;
    private final EmployeeRepository employeeRepository;

    private  final SalaryRepository salaryRepository;

    public void save(Employee employee){
        log.info("Saving by persist method...");
        repository.save(employee);
        log.info("***** Saved *****");
    }

    public void save(String empId, String firstName, String lastname, Long designationId)
    {
        log.info("Saving by Native Query...");

        Designation d = designationRepository.findById(designationId).orElse(null);
        if(d==null) return;


        String sql = "INSERT INTO employees(employee_id, firstname,lastname,designation_id) "
        +" VALUES(:employeeId, :firstName, :lastName, :designationId)";
        Map<String, Object> params = new HashMap<>();
        params.put("employeeId",empId);
        params.put("firstName",firstName);
        params.put("lastName",lastname);
        params.put("designationId",d.getDesignationId());

        repository.save(sql,params,Employee.class);
        log.info("***** Saved *****");
    }

    public Page<Employee> getAll(){
        return employeeRepository.findAll(PageRequest.of(0,5));
    }

    public Employee getById(String id)
    {
        //return employeeRepository.findById(id).orElse(null);

//        String sql = "Select * from employees e where e.employee_id = :employeeId";
//        Map<String, Object> params = new HashMap<>();
//        params.put("employeeId",id);
//        return repository.findOneById(sql,params);

        //return repository.findByIdDynamicEntityGraph(id, Employee.class);

        return repository.findByIdLazy(Employee.class,id);
    }
}
