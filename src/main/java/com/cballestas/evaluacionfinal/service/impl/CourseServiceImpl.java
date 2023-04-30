package com.cballestas.evaluacionfinal.service.impl;

import com.cballestas.evaluacionfinal.dto.CourseDTO;
import com.cballestas.evaluacionfinal.model.Course;
import com.cballestas.evaluacionfinal.repository.ICursoRepository;
import com.cballestas.evaluacionfinal.repository.IGenericRepo;
import com.cballestas.evaluacionfinal.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CrudImpl<Course, CourseDTO, Integer> implements ICourseService {

    private final ICursoRepository cursoRepository;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return cursoRepository;
    }

    @Override
    protected Class<Course> getEntityClass() {
        return Course.class;
    }

    @Override
    protected Class<CourseDTO> getDtoClass() {
        return CourseDTO.class;
    }
}
