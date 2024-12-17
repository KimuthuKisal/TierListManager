package org.kk.tirelist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "org.kk.tirelist")
public class TirelistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TirelistApplication.class, args);
	}

}
