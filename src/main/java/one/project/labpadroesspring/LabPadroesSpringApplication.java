package one.project.labpadroesspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "one.project.labpadroesspring")
public class LabPadroesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesSpringApplication.class, args);
	}

}
