package com.cballestas.evaluacionfinal.controller;

import com.cballestas.evaluacionfinal.dto.StudentDTO;
import com.cballestas.evaluacionfinal.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService service;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() throws Exception {
        return ResponseEntity.ok(
                service.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable(name = "id") Integer id) throws Exception {
        return ResponseEntity.ok(
                service.getById(id)
        );
    }

    /**
     * Método que se encarga de retornar listado de estudiantes ordenados por edad, de forma descendente
     * @return Listado de estudiantes
     */
    @GetMapping("/age-desc")
    public ResponseEntity<List<StudentDTO>> getStudentsByAgeDesc() {
        return service.getStudentsByAgeDesc();
    }

    /**
     * Método que se encarga de retornar los estudiantes matriculados agrupados por nombre de curso
     */
    @GetMapping("/summary")
    public ResponseEntity<Map<String, List<String>>> getStudentsRegistrationByCourse() {
        return service.getStudentsRegistrationByCourse();
    }

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@Valid @RequestBody StudentDTO studentDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                service.save(studentDTO)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@Valid @RequestBody StudentDTO studentDTO, @PathVariable Integer id)
            throws Exception {
        return ResponseEntity.ok().body(
                service.update(studentDTO, id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(name = "id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
