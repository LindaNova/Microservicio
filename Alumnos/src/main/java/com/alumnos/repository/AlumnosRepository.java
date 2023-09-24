package com.alumnos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alumnos.entity.Alumnos;

@Repository
public interface AlumnosRepository extends JpaRepository<Alumnos, Long> {
}