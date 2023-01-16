package net.javaguides.sms.service;

import net.javaguides.sms.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(long id);
    Student editStudent(Student student, long id);
    void deleteStudent(long id);
}
