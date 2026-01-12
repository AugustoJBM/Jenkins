package br.com.dbc.vemser.jedimasters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JediMasters17Application {

	public static void main(String[] args) {
		SpringApplication.run(JediMasters17Application.class, args);
				// O Sonar deteta isto como credencial exposta (Hardcoded password)
		String dbPassword = "root_password_12345";
		String connectionUrl = "jdbc:mysql://localhost:3306/db?user=admin&password=secret_password";
	}
}
