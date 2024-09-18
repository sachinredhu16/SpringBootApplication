package com.school.Redis.ServiceImpl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.school.Redis.Domain.Employee;
import com.school.Redis.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvToDbConvertor {

    @Autowired
    EmployeeRepo employeeRepo;

    String filePath = "D:\\Java DSA\\SpringBootApplication\\src\\main\\resources\\employees.csv";

    public void processCsv() throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Sequential
//            String[] line;
//            List<Employee> entities = new ArrayList<>();
//
//            while ((line = reader.readNext()) != null) {
//                // Convert DTO to Entity
//                Employee entity = new Employee();
//                entity.setId(Integer.parseInt(line[0]));
//                entity.setName(line[1]);
//                entity.setDepartment(line[2]);
//                entity.setSalary(Long.parseLong(line[3]));
//
//                entities.add(entity);
//            }

            // Parallell
            List<String[]> lines = reader.readAll();

            List<Employee> entities = lines.parallelStream().map(
                    line -> {
                        Employee entity = new Employee();
                        entity.setId(Integer.parseInt(line[0]));
                        entity.setName(line[1]);
                        entity.setDepartment(line[2]);
                        entity.setSalary(Long.parseLong(line[3]));
                        return entity;
                    }).collect(Collectors.toList());

            employeeRepo.saveAll(entities);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
