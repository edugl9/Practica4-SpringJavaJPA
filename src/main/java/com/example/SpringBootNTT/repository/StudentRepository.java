package com.example.SpringBootNTT.repository;

import com.example.SpringBootNTT.entity.Curso;
import com.example.SpringBootNTT.entity.Student;
import com.example.SpringBootNTT.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private StudentRepositoryDao studentRepositoryDao;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public void creacionEstudiante(Student student){
        studentRepositoryDao.save(student);
    }

    public List<Student> getStudents() {
        return (List<Student>) studentRepositoryDao.findAll();
    }

    public List<Teacher> getTeachersByNameAndAge(String nombre, Integer edad){
        return teacherRepository.findTeacherByNombreAndEdad(nombre,edad);
    }

    public List<Curso> getfindCursosByIdAndNombre(Integer id, String nombre){
        return cursoRepository.findCursoByIdAndNombre(id, nombre);
    }
}
