package com.tryjpa.demojpa.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email is used");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw  new IllegalStateException(
                    String.format("Student with id %d does not exists",studentId));
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Student with id %d, does not exists",studentId)
                ));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)){
//            studentRepository.updateStudentNameById(studentId,name);
            student.setName(name);
        }


        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw  new IllegalStateException("email is used");
            }
//            studentRepository.updateStudentEmailById(studentId,email);
            student.setEmail(email);
        }
    }
}
