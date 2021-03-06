package com.jobayed.customsecurity.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@NoArgsConstructor @AllArgsConstructor
@Data
public class Employee {
    @Id
    @Column(name = "employee_id",length = 10, nullable = false,unique = true)
    private String employeeId;

    @Column(name = "firstname",length = 50, nullable = false)
    private String firstName;

    @Column(name = "lastname",length = 50, nullable = true)
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="designation_id",referencedColumnName = "designation_id")
    private Designation designationId;


}
