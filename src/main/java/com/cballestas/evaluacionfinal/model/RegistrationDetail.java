package com.cballestas.evaluacionfinal.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "registration_detail")
public class RegistrationDetail {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "registration_id", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_REGISTRATION"))
    Registration registration;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_COURSE"))
    Course course;

    @Column(nullable = false)
    String classRoom;
}
