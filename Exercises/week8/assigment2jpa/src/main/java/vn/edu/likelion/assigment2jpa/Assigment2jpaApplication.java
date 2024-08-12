package vn.edu.likelion.assigment2jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import vn.edu.likelion.assigment2jpa.repository.UserRepository;
import vn.edu.likelion.assigment2jpa.service.UserService;

@SpringBootApplication
public class Assigment2jpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(Assigment2jpaApplication.class, args);
	}
}
