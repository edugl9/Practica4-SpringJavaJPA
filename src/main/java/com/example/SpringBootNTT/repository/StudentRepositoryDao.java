package com.example.SpringBootNTT.repository;

import com.example.SpringBootNTT.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositoryDao extends CrudRepository<Student, Integer> {

}
