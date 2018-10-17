package com.young.FirstSpaceTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//用来扫描@Controller  @Service  @Repository这类,需要装配到spring 容器中
@ComponentScan(basePackages = {"com.young.FirstSpaceTest.*"})
public class FirstSpaceTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpaceTestApplication.class, args);
	}
}
