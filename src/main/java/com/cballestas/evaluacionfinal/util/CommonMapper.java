package com.cballestas.evaluacionfinal.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommonMapper {

    private final ModelMapper mapper;

    public <T, S> S convertToDto(T obj, Class<S> dtoClazz) {
        return mapper.map(obj, dtoClazz);
    }

    public <T, S> T convertToEntity(S dto, Class<T> entityClazz) {
        return mapper.map(dto, entityClazz);
    }
}
