package com.example.library;

import org.springframework.ai.vectorstore.mariadb.autoconfigure.MariaDbStoreAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.flyway.autoconfigure.FlywayAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		FlywayAutoConfiguration.class,
		MariaDbStoreAutoConfiguration.class

})
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
}



//@SpringBootApplication
//public class BookApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(BookApplication.class, args);
//	}
//
//}
