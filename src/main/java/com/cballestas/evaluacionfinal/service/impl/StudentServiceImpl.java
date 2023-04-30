package com.cballestas.evaluacionfinal.service.impl;

import com.cballestas.evaluacionfinal.dto.StudentDTO;
import com.cballestas.evaluacionfinal.model.Registration;
import com.cballestas.evaluacionfinal.model.RegistrationDetail;
import com.cballestas.evaluacionfinal.model.Student;
import com.cballestas.evaluacionfinal.repository.IEstudianteRepository;
import com.cballestas.evaluacionfinal.repository.IGenericRepo;
import com.cballestas.evaluacionfinal.repository.IRegistrationRepository;
import com.cballestas.evaluacionfinal.service.IStudentService;
import com.cballestas.evaluacionfinal.util.CommonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CrudImpl<Student, StudentDTO, Integer> implements IStudentService {

    private final IEstudianteRepository studentRepository;
    private final CommonMapper mapper;
    private final IRegistrationRepository registrationRepository;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return studentRepository;
    }

    @Override
    protected Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    protected Class<StudentDTO> getDtoClass() {
        return StudentDTO.class;
    }

    /**
     * Método que retorna listado de estudiantes ordenados por edad (forma descendente)
     * @return Lista de tipo StudentDTO
     */
    @Override
    public ResponseEntity<List<StudentDTO>> getStudentsByAgeDesc() {
        List<StudentDTO> students = getAllRecords()
                .get()
                .stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .map(student -> mapper.convertToDto(student, StudentDTO.class))
                .toList();
        return ResponseEntity.ok(students);
    }

    /**
     * Método que devuelve los estudiantes matriculados, delimitados por curso
     * @return Map de tipo Map<String, List<String>>
     */
    @Override
    public ResponseEntity<Map<String, List<String>>> getStudentsRegistrationByCourse() {
        Stream<Registration> registrationStream = registrationRepository.findAll().stream();
        Stream<Set<RegistrationDetail>> lstStream = registrationStream.map(Registration::getDetails);

        Stream<RegistrationDetail> detailStream = lstStream.flatMap(Collection::stream);

        Map<String, List<String>> studentsByCourse = detailStream.collect(groupingBy(d -> d.getCourse().getName(), Collectors.mapping(
                e -> e.getRegistration().getStudent().getName() + " " + e.getRegistration().getStudent().getLastname(),
                Collectors.toList())));

        return ResponseEntity.ok(studentsByCourse);
    }

    private Supplier<List<Student>> getAllRecords() {
        return studentRepository::findAll;
    }
}
