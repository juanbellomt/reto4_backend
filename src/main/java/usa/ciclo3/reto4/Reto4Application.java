package usa.ciclo3.reto4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"usa.ciclo3.reto4.model"})
public class Reto4Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto4Application.class, args);
	}

}
