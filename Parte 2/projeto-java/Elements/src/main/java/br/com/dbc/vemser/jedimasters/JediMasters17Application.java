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

				// O Sonar detesta o uso de MD5 por ser inseguro, isso gera um erro crítico
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update("minha_senha_secreta".getBytes());
			byte[] digest = md.digest();
			
			// Outro erro: Print de stack trace direto no console (Code Smell/Security)
		} catch (Exception e) {
			e.printStackTrace(); 
		}

		// Senha explícita em variável com nome padrão que o scanner busca
		String hardcodedPassword = "admin_password_dont_use_this_123";
	}
}
