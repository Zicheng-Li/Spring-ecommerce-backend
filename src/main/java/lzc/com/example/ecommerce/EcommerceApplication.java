package lzc.com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
}
// spring have pagination out of box, by default will pass 20 elements
// we use ANNOTATED strategy to only display the annotated spring data rest properties