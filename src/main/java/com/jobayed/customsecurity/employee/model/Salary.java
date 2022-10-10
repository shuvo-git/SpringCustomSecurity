package com.jobayed.customsecurity.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigDecimal;

@SqlResultSetMappings(
        @SqlResultSetMapping(
                name = "salaryTwoColResultMapping",
                classes = {
                    @ConstructorResult(
                        targetClass=com.jobayed.customsecurity.employee.dto.SalResultMap.class,
                        columns={
                                @ColumnResult(name="EMP", type=String.class),
                                @ColumnResult(name="SAL", type=Double.class)
                        }
                    )
                }
        )
)
@NamedNativeQueries({
        @NamedNativeQuery(name = "highestSalary", query = "select * from salaries", resultClass = Salary.class),
        @NamedNativeQuery(name = "Salary.salaryTwoCol", query = "SELECT employee as EMP, salary as SAL FROM salaries",
                resultSetMapping = "salaryTwoColResultMapping")
})
@Data @AllArgsConstructor @NoArgsConstructor
@Slf4j
@Entity
@Table(name = "salaries")
public class Salary {
    @Id
    @Column(name = "salary_id")
    private Long salaryId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee", referencedColumnName = "employee_id")
    private Employee employee ;

    private BigDecimal salary;
}
