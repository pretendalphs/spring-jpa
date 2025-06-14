package com.one.spring_jpa.repositories;

import com.one.spring_jpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.email = :email")
    Optional<Student> findStudentByEmail(@Param("email") String email);

    @Query("DELETE FROM Student s WHERE s.email = :email")
    int deleteByEmail(@Param("email") String email);
}
