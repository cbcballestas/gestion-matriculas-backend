package com.cballestas.evaluacionfinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user_data")
public class User {

    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;

    @ManyToOne //(FK)
    @JoinColumn(name = "id_role", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_ROLE"))
    private Role role; //JPQL Java Persistence Query Language | SQL

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;
}
