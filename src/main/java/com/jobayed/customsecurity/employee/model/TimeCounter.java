package com.jobayed.customsecurity.employee.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Slf4j
@Entity
@Data
@Table(name = "employee_time_count")
@NoArgsConstructor @AllArgsConstructor
@XmlRootElement
public class TimeCounter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "employee_id", unique = true,nullable = false, length = 10)
    private String employeeId;

    @Column(name = "time_count_in_min", nullable = false)
    private Long timeCountInMin = 0L;
}
