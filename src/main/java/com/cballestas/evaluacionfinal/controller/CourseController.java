package com.cballestas.evaluacionfinal.controller;

import com.cballestas.evaluacionfinal.dto.CourseDTO;
import com.cballestas.evaluacionfinal.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService service;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() throws Exception {
        return ResponseEntity.ok(
                service.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable(name = "id") Integer id) throws Exception {
        return ResponseEntity.ok(
                service.getById(id)
        );
    }

    @PostMapping
    public ResponseEntity<CourseDTO> saveCourse(@Valid @RequestBody CourseDTO courseDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                service.save(courseDTO)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@Valid @RequestBody CourseDTO courseDTO, @PathVariable Integer id)
            throws Exception {
        return ResponseEntity.ok().body(
                service.update(courseDTO, id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable(name = "id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
