package com.dh.clase23;

import com.dh.clase23.dao.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase23Application {

	public static void main(String[] args) {
		DB.dropCreateTables();
		DB.insertTestSubjects();
		SpringApplication.run(Clase23Application.class, args);
	}

}
