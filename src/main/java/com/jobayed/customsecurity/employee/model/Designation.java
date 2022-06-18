package com.jobayed.customsecurity.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "designations")
@NoArgsConstructor @AllArgsConstructor
@Data
public class Designation {
    @Id
    @Column(name = "designation_id",length = 10, nullable = false,unique = true)
    private Long designationId;

    @Column(name = "short_designation",length = 6, nullable = false)
    private String shortDesignation;

    @Column(name = "designation",length = 30, nullable = false)
    private String designation;
}
