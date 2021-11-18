package com.example.SpringBootNTT.service;

import com.example.SpringBootNTT.entity.Student;
import com.example.SpringBootNTT.entity.Teacher;
import com.example.SpringBootNTT.repository.StudentRepository;
import com.example.SpringBootNTT.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public void  AddStudent(Student student){
        studentRepository.creacionEstudiante(student);
    }

    public List<Student> getLista() {
        return null;
    }

    public Student getStudent(String name) {
        return null;
    }

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public List<Teacher> getTeacherByNameAnAge(@PathVariable String name, int edad){
        return teacherRepository.findTeacherByNombreAndEdad(name, edad);
    }

    /*
    private List<Student> students = new ArrayList<>(List.of(new Student(1, "Jose"),
            new Student(2, "Maria")));

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudent(String studentName){
        for (Student s:students) {
            if(studentName.equals(s.getName())){
                return s;
            }
        }
        return new Student("Alumno no encontrado");
    }

    public List<Student> getLista() {
        return students;
    }*/
}
