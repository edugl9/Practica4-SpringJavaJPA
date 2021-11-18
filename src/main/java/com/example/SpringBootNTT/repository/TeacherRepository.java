package com.example.SpringBootNTT.repository;

import com.example.SpringBootNTT.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    public List<Teacher> findTeacherByNombreAndEdad(String nombre, Integer edad);

    @Query(value = "Select * from profesores where nombre=:nombre and edad=:edad",nativeQuery = true)
    public List<Teacher> findTeacherByNombreAndEdadPorQueryNativa(String nombre, Integer edad);

    //@Query(value = "Select t from teacher t where t.nombre=?1 and t.edad=?2")
    //public List<Teacher> findTeacherByNombreAndEdadPorJPQL(@Param("nombre") String nombre, Integer edad);

    //@Query(value = "Select t.nombre from teacher t where t.edad=:edad")
    //public List<String> findTeacherByNombreAndEdadPorJPQL2(Integer edad);

    //---- crear una proyeccion
    //@Query(value = "Select new com.example.SpringBootNTT.entity.Teacher2(t.nombre, t.direccion) from teacher t where t.edad=:edad")
    //public List<Teacher2> findTeacherByNombreAndEdadPorJPQL2(Integer edad);
}
