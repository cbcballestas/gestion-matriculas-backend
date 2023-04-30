package com.cballestas.evaluacionfinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDTO {

    private Integer id;

    @NotNull(message = "Role Name can not be null")
    @NotEmpty(message = "Role Name can not be empty")
    private String name;

    @NotNull
    private boolean enabled;
}
