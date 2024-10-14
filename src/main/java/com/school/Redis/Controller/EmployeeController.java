package com.school.Redis.Controller;


import com.school.Redis.Domain.Employee;
import com.school.Redis.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("getAllEmployee")
    public Page<Employee> getAllEmployee(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize){

        Sort sort = Sort.by(Sort.Direction.DESC, "salary");
        Pageable pageable = PageRequest.of(pageNum,pageSize, sort);

        Page<Employee> byId = employeeRepo.findAll(pageable);

        return byId;

    }
}
