package com.example.SpringBootNTT.repository;

import com.example.SpringBootNTT.entity.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoRepository extends CrudRepository<Curso, Integer> {
    public List<Curso> findCursoByIdAndNombre(Integer id, String nombre);

    @Query(value = "Select * from cursos where id=:id",nativeQuery = true)
    public List<Curso> findCursoByIdAndNombrePorQueryNativa(Integer id);

    //@Query(value = "Select * from cursos c where c.id=:?1 and c.nombre=:?2")
    //public List<Curso> findCursoByByIdAndNombrePorJPQL(Integer id, String nombre);
}
