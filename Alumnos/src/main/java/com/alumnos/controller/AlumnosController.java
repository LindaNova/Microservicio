package com.alumnos.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.alumnos.entity.Alumnos;
import com.alumnos.service.AlumnosService; 

@RestController
@RequestMapping("/api/alumnos")
public class AlumnosController {

    private final AlumnosService alumnosService;

 
    public AlumnosController(AlumnosService alumnosService) {
        this.alumnosService = alumnosService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Alumnos>> obtenerTodosLosAlumnos() {
        List<Alumnos> alumnos = alumnosService.obtenerTodosLosAlumnos();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumnos> obtenerAlumnosPorId(@PathVariable Long id) {
        Optional<Alumnos> alumno = alumnosService.obtenerAlumnoPorId(id);
        if (alumno.isPresent()) {
            return new ResponseEntity<>(alumno.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Alumnos> guardarAlumno(@RequestBody Alumnos alumno) {
        Alumnos nuevoAlumno = alumnosService.guardarAlumno(alumno);
        return new ResponseEntity<>(nuevoAlumno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumnos> actualizarAlumno(@PathVariable Long id, @RequestBody Alumnos nuevoAlumno) {
        Alumnos alumnoActualizado = alumnosService.actualizarAlumno(id, nuevoAlumno);
        if (alumnoActualizado != null) {
            return new ResponseEntity<>(alumnoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}