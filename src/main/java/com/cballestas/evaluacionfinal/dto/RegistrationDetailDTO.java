package com.cballestas.evaluacionfinal.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RegistrationDetailDTO {

    @EqualsAndHashCode.Include
    Integer id;

    @JsonBackReference
    RegistrationDTO registration;

    @JsonIncludeProperties(value = {"id"})
    @NotNull(message = "Course is required")
    CourseDTO course;

    @NotEmpty(message = "Course can not be empty")
    @NotNull(message = "Course is required")
    @JsonProperty("class_room")
    String classRoom;
}
