package com.cballestas.evaluacionfinal.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseDTO {
    Integer id;
    @NotEmpty(message = "Name must not be empty")
    @NotNull(message = "Name must not be null")
    String name;
    @NotEmpty(message = "Acronyms must not be empty")
    @NotNull(message = "Acronyms must not be null")
    String acronyms;
    boolean status;
}

