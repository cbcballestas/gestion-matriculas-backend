package com.cballestas.evaluacionfinal.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "students")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    Integer id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String lastname;

    @Column(nullable = false)
    String dni;

    @Column(nullable = false)
    int age;
}
