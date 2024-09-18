package com.school.Redis;

import com.school.Redis.ServiceImpl.CsvToDbConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableCaching
public class SpringBootApplication implements CommandLineRunner {

	@Autowired
	CsvToDbConvertor csvToDbConvertor;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		csvToDbConvertor.processCsv();
	}
}
