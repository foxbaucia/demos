package co.softwarebox.demos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import co.softwarebox.demos.account.Account;
import co.softwarebox.demos.account.AccountRepository;

@EnableCaching
@SpringBootApplication
public class DemoApiApp extends SpringBootServletInitializer {


    public static final String CLIENT_NAME = "demos";
    public static final String CLIENT_PASSWORD = "password";

	
    public static void main(String [] args) {
		SpringApplication.run(DemoApiApp.class, args);

	}


    @Bean
    CommandLineRunner init(final AccountRepository accountRepository) {
      
      return new CommandLineRunner() {

        @Override
        public void run(String... arg0) throws Exception {
          accountRepository.save(new Account(CLIENT_NAME, CLIENT_PASSWORD));
        }
        
      };

    }
    
}
