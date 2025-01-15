package com.cvm.week2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "emplyee", version = "2.0",description="employye data"))
public class AnjWeek2Application {

	public static void main(String[] args) {
		SpringApplication.run(AnjWeek2Application.class, args);
	}

}
