package com.cballestas.evaluacionfinal.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "registration")
@Entity
public class Registration {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    LocalDateTime registrationDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, foreignKey = @ForeignKey(name = "FK_REGISTRATION_STUDENT"))
    Student student;

    @Column(nullable = false)
    boolean status;

    @ToString.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "registration",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    Set<RegistrationDetail> details;
}
