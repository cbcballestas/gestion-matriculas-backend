package com.cballestas.evaluacionfinal.service;

import com.cballestas.evaluacionfinal.dto.StudentDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IStudentService extends ICrud<StudentDTO, Integer> {
    ResponseEntity<List<StudentDTO>> getStudentsByAgeDesc();
    ResponseEntity<Map<String, List<String>>> getStudentsRegistrationByCourse();
}
