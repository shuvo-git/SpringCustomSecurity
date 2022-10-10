package com.jobayed.customsecurity;

import com.jobayed.customsecurity.auth_user.model.Role;
import com.jobayed.customsecurity.auth_user.model.User;
import com.jobayed.customsecurity.auth_user.service.UserService;
import com.jobayed.customsecurity.employee.dto.SalResultMap;
import com.jobayed.customsecurity.employee.model.Designation;
import com.jobayed.customsecurity.employee.model.Employee;
import com.jobayed.customsecurity.employee.model.Salary;
import com.jobayed.customsecurity.employee.model.TimeCounter;
import com.jobayed.customsecurity.employee.repository.SalaryRepository;
import com.jobayed.customsecurity.employee.service.DesgnationService;
import com.jobayed.customsecurity.employee.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class CustomSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService,
                          DesgnationService desgnationService,
                          EmployeeService employeeService,
                          SalaryRepository salaryRepository
    ) {
        return args -> {

            SalResultMap obj = new SalResultMap();
            obj.setEmployeeRes("EMP01155");
            obj.setSalaryRes(40000.0);

            Arrays.stream(SalResultMap.class.getDeclaredFields())
                    .forEach(field -> {
                        field.setAccessible(true);
                        System.out.println(field.getName());
                        try {
                            System.out.println(field.get(obj));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    });


//			userService.saveRole(new Role(null,"ROLE_ADMIN"));
//			userService.saveRole(new Role(null,"ROLE_USER"));
//
//			userService.saveUser(new User(null,"Jobayed Ullah","jobayed","1234",new ArrayList<>()));
//			userService.saveUser(new User(null,"Altaf Mahmood","altaf",  "1234",new ArrayList<>()));
//			userService.saveUser(new User(null,"Jasim Uddin","jasim",  "1234",new ArrayList<>()));
//
//			userService.assignRole("jobayed","ROLE_ADMIN");
//			userService.assignRole("altaf",  "ROLE_USER");
//			userService.assignRole("jasim",  "ROLE_USER");
//
//			desgnationService.create(new Designation(1L,"SWE","Software Engineer"));
//			desgnationService.create(new Designation(2L,"Sr.SWE","Sr. Software Engineer"));
//			desgnationService.create(new Designation(3L,"Jr.SWE","Jr. Software Engineer"));
//
//
//
//
//
//			Designation d = desgnationService.get(1L);
//			Salary s = salaryRepository.findById(1L).orElse(null);
//			employeeService.save(new Employee("E000000001","Jobayed","Ullah",d));
//
//			employeeService.save("E000000002","Shakil","Khan",2L);

//
//			salaryRepository.save(new Salary(1L,employeeService.getById("E000000001"), new BigDecimal(90800)));
//			salaryRepository.save(new Salary(2L,employeeService.getById("E000000002"),new BigDecimal(120760)));
//


        };
    }

}
