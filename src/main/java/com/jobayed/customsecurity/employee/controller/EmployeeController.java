package com.jobayed.customsecurity.employee.controller;

import com.jobayed.customsecurity.employee.dto.SalResultMap;
import com.jobayed.customsecurity.employee.model.Employee;
import com.jobayed.customsecurity.employee.model.Salary;
import com.jobayed.customsecurity.employee.model.TimeCounter;
import com.jobayed.customsecurity.employee.service.EmployeeSalaryService;
import com.jobayed.customsecurity.employee.service.EmployeeService;
import com.jobayed.customsecurity.employee.service.TimeCounterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeSalaryService serviceSalary;

    private final TimeCounterService timeCounterService;

    @PostMapping("/create")
    public ResponseEntity<Employee> create(){
        return null;
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getAll(){
        return ResponseEntity.ok().body(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id){
        return ResponseEntity.ok().body(employeeService.getById(id));
    }

    @GetMapping("/salary")
    public ResponseEntity<Collection<Salary>> getAllSalary(){
        return ResponseEntity.ok().body(serviceSalary.getAllSalary());
    }

    @GetMapping("/salary-two")
    public ResponseEntity<Collection<SalResultMap>> getAllSalaryTwo(){
        return ResponseEntity.ok().body(serviceSalary.getAllSalaryTwoCol());
    }

    @GetMapping("/salary/{id}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable Long id){
        return ResponseEntity.ok().body(serviceSalary.getSalaryById(id));
    }

    @PostMapping(value = "/time",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<TimeCounter> saveOrUpdateTimeCount(@RequestBody TimeCounter request){
        return ResponseEntity.ok(timeCounterService.save(request));
    }

    @GetMapping("/time/{employeeId}")
    public ResponseEntity<TimeCounter> saveOrUpdateTimeCount(@PathVariable String employeeId){
        return ResponseEntity.ok(timeCounterService.getByEmployeeId(employeeId));
    }

}
