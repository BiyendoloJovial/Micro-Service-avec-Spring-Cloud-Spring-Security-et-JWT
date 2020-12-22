package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start (CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null,"Jovial","Jovial@gmail.com"));
			customerRepository.save(new Customer(null,"BlackJovial","BlackJovial@gmail.com"));
			customerRepository.save(new Customer(null,"Blacky","Blacky@gmail.com"));
			customerRepository.save(new Customer(null,"Juste","Juste@gmail.com"));
//			customerRepository.findAll().forEach(cust ->{
//				System.out.println(cust.toString());
//			} );
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
