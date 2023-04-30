package com.cballestas.evaluacionfinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationDTO {
    @EqualsAndHashCode.Include
    Integer id;

    @NotNull(message = "Registration date is required")
    @JsonProperty("registration_date")
    LocalDateTime registrationDate;

    @JsonIncludeProperties(value = {"id"})
    @NotNull( message = "Student can not be null")
    StudentDTO student;

    @NotNull(message = "Status is required")
    boolean status;

    @NotNull(message = "Registration Details are required")
    @JsonManagedReference
    Set<RegistrationDetailDTO> details;
}
