package br.com.curtaocodigo.simplerestapidocexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ="br.com.curtaocodigo.simplerestapidocexample")
public class SimpleRestApiDocExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleRestApiDocExampleApplication.class, args);
	}
}