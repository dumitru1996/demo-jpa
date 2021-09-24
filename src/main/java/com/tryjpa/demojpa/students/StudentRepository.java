package com.tryjpa.demojpa.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    // SELECT * FROM student WHERE email = ?;
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query(value = "UPDATE Student s SET s.name= :name WHERE s.id= :studentId",
    nativeQuery = true)
    Optional<Student> updateStudentNameById(
            @Param("studentId") Long studentId,
            @Param("name") String name);

    @Query(value = "UPDATE Student s SET s.email= :email WHERE s.id= :studentId",
    nativeQuery = true)
    Optional<Student> updateStudentEmailById(
            @Param("studentId") Long studentId,
            @Param("email")String email);

}
