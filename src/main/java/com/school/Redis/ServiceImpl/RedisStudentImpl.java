package com.school.Redis.ServiceImpl;

import com.school.Redis.Domain.Student;
import com.school.Redis.Repository.RedisStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisStudentImpl {

    @Autowired
    RedisStudentRepo redisStudentRepo;

    public boolean addStudent(Student student){
        try{
            Student s = redisStudentRepo.save(student);
            System.out.println(s.toString());
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public Student getStudent(int id){
        System.out.println("Getting from Database because its DB call !");
        Student student = redisStudentRepo.findById(id).get();
        return student;
    }
}
