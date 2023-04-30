package com.cballestas.evaluacionfinal.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDTO {
    Integer id;

    @NotEmpty(message = "Name must not be empty")
    @NotNull(message = "Name must not be null")
    String name;

    @NotEmpty(message = "Lastname must not be empty")
    @NotNull(message = "Lastname must not be null")
    String lastname;

    @NotEmpty(message = "Dni must not be empty")
    @NotNull(message = "Dni must not be null")
    String dni;

    @NotNull
    @Min(value = 1,message = "Age must be a valid number, min 1 is required")
    int age;
}
