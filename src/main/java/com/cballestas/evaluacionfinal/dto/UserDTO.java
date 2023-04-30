package com.cballestas.evaluacionfinal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Integer idUser;

    @JsonIncludeProperties(value = {"idRole", "nameRole"})
    @NotNull
    private RoleDTO role;

    @NotNull(message="User Name can not be null")
    @NotEmpty(message="User Name can not be empty")
    @Size(min = 3, max = 50)
    private String username;

    //@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 10, max = 60, message = "Password must be between 10 and 60 characters")
    private String password;

    @NotNull
    private boolean enabled;

}
