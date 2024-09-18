package com.school.Redis.Repository;

import com.school.Redis.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisStudentRepo extends JpaRepository<Student,Integer> {
}
