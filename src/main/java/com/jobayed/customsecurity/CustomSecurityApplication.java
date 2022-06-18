package com.jobayed.customsecurity;

import com.jobayed.customsecurity.auth_user.service.UserService;
import com.jobayed.customsecurity.employee.model.Designation;
import com.jobayed.customsecurity.employee.model.Employee;
import com.jobayed.customsecurity.employee.service.DesgnationService;
import com.jobayed.customsecurity.employee.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService,
						  DesgnationService desgnationService,
						  EmployeeService employeeService
	){
		return args->{
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

//			desgnationService.create(new Designation(1L,"SWE","Software Engineer"));
//			desgnationService.create(new Designation(2L,"Sr.SWE","Sr. Software Engineer"));
//			desgnationService.create(new Designation(3L,"Jr.SWE","Jr. Software Engineer"));

			//Designation tmp = desgnationService.get(1L);
			//employeeService.save(new Employee("E000000001","Jobayed","Ullah",tmp));

			//employeeService.save("E000000002","Ashrafun","Naher",2L);

		};
	}

}
