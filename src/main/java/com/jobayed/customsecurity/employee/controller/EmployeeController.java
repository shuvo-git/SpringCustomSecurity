package com.jobayed.customsecurity.employee.controller;

import com.jobayed.customsecurity.employee.model.Employee;
import com.jobayed.customsecurity.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping("/create")
    public ResponseEntity<Employee> create(){
        return null;
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

}
