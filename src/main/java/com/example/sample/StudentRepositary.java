package com.example.sample;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositary extends CrudRepository<Student, Long> {

    List<Student> findByLastName(String lastName);

    Student findById(long id);
}