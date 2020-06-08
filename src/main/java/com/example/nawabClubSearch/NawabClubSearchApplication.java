package com.example.nawabClubSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"com.example.nawabClubSearch.controller"
})
@SpringBootApplication
public class NawabClubSearchApplication {

	public static void main(String[] args) {
		System.out.println("hiii");
		SpringApplication.run(NawabClubSearchApplication.class, args);
	}

}
