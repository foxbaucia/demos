package co.softwarebox.demos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoApiApp extends SpringBootServletInitializer {

    public static void main(String [] args) {
		SpringApplication.run(DemoApiApp.class, args);

	}

}
