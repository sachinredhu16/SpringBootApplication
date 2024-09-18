package com.school.Redis.Controller;

import com.school.Redis.Domain.ResponseDto;
import com.school.Redis.Domain.Student;
import com.school.Redis.ServiceImpl.RedisStudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class RedisStudentController {

    @Autowired
    RedisStudentImpl redisStudentImpl;


//    @CachePut(value = "students", key = "#student.id")
    @PostMapping("/add")
    public ResponseDto addStudent(@RequestBody Student student) throws Exception {
        boolean b = redisStudentImpl.addStudent(student);

        ResponseDto response = new ResponseDto();
        if(b)
            response.setStatus("Student added SuccessFully !");
        else
            response.setStatus("Unable to add.Please try again !");



        return response;

    }


    @Cacheable(value = "students", key = "#id")
    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable(value = "id") int id){
        return redisStudentImpl.getStudent(id);
    }

    @CacheEvict(cacheNames = "students", allEntries = true)
    @GetMapping("cacheEvict")
    public void evictCache() {
        // This method will evict all entries from the "students" cache
    }

}
