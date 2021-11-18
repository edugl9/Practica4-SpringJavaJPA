package com.example.SpringBootNTT.controller;

import com.example.SpringBootNTT.entity.Curso;
import com.example.SpringBootNTT.entity.Student;
import com.example.SpringBootNTT.entity.Teacher;
import com.example.SpringBootNTT.repository.CursoRepository;
import com.example.SpringBootNTT.repository.StudentRepository;
import com.example.SpringBootNTT.repository.TeacherRepository;
import com.example.SpringBootNTT.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CursoRepository cursoRepository;

    /*@GetMapping("/{nombre}")
    public String holaMundo(@PathVariable String nombre){
        return "Hola mundo" + nombre;
    }*/

    //Creacion del alumno
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        System.out.println("Se hizo la solicitud");
        service.AddStudent(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        return service.getStudents();
    }

//------------------------------- TEACHER -----------------------
    @GetMapping("/teacher/{name}/{edad}")
    public List<Teacher> getTeacherByNameAnAge(@PathVariable("nombre") String nombre, @PathVariable("edad") Integer edad){
        return studentRepository.getTeachersByNameAndAge(nombre, edad);
    }

    @GetMapping("/teacherByQuery/{nombre}/{edad}")
    public List<Teacher> getTeacherByNameAndAgeByQuery(@PathVariable("nombre") String nombre, @PathVariable("edad") Integer edad){
        return teacherRepository.findTeacherByNombreAndEdadPorQueryNativa(nombre,edad);
    }

    /*@GetMapping("/teacherByJPQL/{nombre}/{edad}")
    public List<Teacher> getTeacherByNameAndAgeByJPQL(@PathVariable("nombre") String nombre, @PathVariable("edad") Integer edad){
        return teacherRepository.findTeacherByNombreAndEdadPorJPQL(nombre,edad);
    }*/

    /*
    @GetMapping("/teacher2/{edad}")
    public List<Teacher2> getTeacherByNameAnAge(@PathVariable("edad") Integer edad){
        return studentRepository.getTeachersByNameAndAge2(edad);
    }

    @GetMapping("/teacherByJPQL/{edad}")
    public List<String> getTeacherByNameAndAgeByJPQL(@PathVariable("edad") Integer edad){
        return teacherRepository.findTeacherByNombreAndEdadPorJPQL2(edad);
    }
     */
//------------------------------- CURSO -----------------------
    //findCursoByIdAndNombre
    @GetMapping("/curso/{id}/{nombre}")
    public List<Curso> getfindCursoByIdAndNombre(@PathVariable("id") Integer id, @PathVariable("nombre") String nombre){
        return studentRepository.getfindCursosByIdAndNombre(id, nombre);
    }

    @GetMapping("/cursoByQuery/{id}")
    public List<Curso> getCursoByIdAndNombrePorQuery(@PathVariable("id") Integer id){
        return cursoRepository.findCursoByIdAndNombrePorQueryNativa(id);
    }

    /*@GetMapping("/cursoByJPQL/{id}/{nombre}")
    public List<Teacher> getCursoByIdAndNombreByJPQL(@PathVariable("id") Integer id, @PathVariable("nombre") String nombre){
        return teacherRepository.findCursoByIdAndNombrePorJPQL(id,nombre);
    }*/


//----------------------------------------------------------------------------------------------------------------------------------
    /*
    @GetMapping("/{pornombre}/{nombrevariable}")
    public Student getStudentByName(@PathVariable("nombrevariable") String name) {
        return service.getStudent(name);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }

    public Student getStudentByName(@PathVariable("nombreVariable") String name){
        return service.getStudent(name);
    }

    @GetMapping("/homepage")
    public String homepage(Model model){
        model.addAttribute("yoSoy", "eduardo");
        return "home";
        //model.addAllAttributes("students");
    }
    */
}
