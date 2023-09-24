package com.alumnos.service;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.alumnos.entity.Alumnos;
import com.alumnos.repository.AlumnosRepository;

@Service
public class AlumnosService {

    private final AlumnosRepository alumnosRepository;

    public AlumnosService(AlumnosRepository alumnosRepository) {
        this.alumnosRepository = alumnosRepository;
    }

    public List<Alumnos> obtenerTodosLosAlumnos() {
        return alumnosRepository.findAll();
    }

    public Optional<Alumnos> obtenerAlumnoPorId(Long id) {
        return alumnosRepository.findById(id);
    }

    public Alumnos guardarAlumno(Alumnos alumno) {
        return alumnosRepository.save(alumno);
    }

    public Alumnos actualizarAlumno(Long id, Alumnos nuevoAlumno) {
        if (alumnosRepository.existsById(id)) {
            nuevoAlumno.setIdAlumnos(id);
            return alumnosRepository.save(nuevoAlumno);
        }
        return null;
    }
}