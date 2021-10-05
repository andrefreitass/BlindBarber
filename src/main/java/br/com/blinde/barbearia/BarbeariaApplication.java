package br.com.blinde.barbearia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class BarbeariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbeariaApplication.class, args);
	}
}