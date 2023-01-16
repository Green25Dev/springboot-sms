package net.javaguides.sms.service.impl;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;
import net.javaguides.sms.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "Id", id));
        return student;
    }

    @Override
    public Student editStudent(Student student, long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "Id", id));
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "Id", id));
        studentRepository.deleteById(id);
    }
}
