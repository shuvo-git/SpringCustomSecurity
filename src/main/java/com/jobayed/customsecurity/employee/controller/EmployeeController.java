package com.jobayed.customsecurity.employee.controller;

import com.jobayed.customsecurity.employee.model.Employee;
import com.jobayed.customsecurity.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id){
        return ResponseEntity.ok().body(service.getById(id));
    }

}
