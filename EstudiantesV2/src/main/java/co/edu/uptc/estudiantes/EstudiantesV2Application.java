package co.edu.uptc.estudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "co.edu.uptc" })
@ComponentScan(basePackages = { "co.edu.uptc" })
@EntityScan(basePackages = { "co.edu.uptc.data.entities" })
@EnableJms
public class EstudiantesV2Application {

	public static void main(String[] args) {
		SpringApplication.run(EstudiantesV2Application.class, args);
	}

}
