package org.sid.inventory.service;

import org.sid.inventory.service.entities.Product;
import org.sid.inventory.service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start (ProductRepository productRepository,
							 RepositoryRestConfiguration restConfiguration) {
		return args -> {
			restConfiguration.exposeIdsFor(Product.class);
			productRepository.save(new Product(null,"Ord Dell Lat 450",6300));
			productRepository.save(new Product(null,"Ord HP  878",8700));
			productRepository.save(new Product(null,"Ord Azus RT",5380));
			productRepository.save(new Product(null,"Ord Microssoft",2488));
			productRepository.findAll().forEach(System.out::println);
		};

	}

}
