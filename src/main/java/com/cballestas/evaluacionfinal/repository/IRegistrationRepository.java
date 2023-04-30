package com.cballestas.evaluacionfinal.repository;

import com.cballestas.evaluacionfinal.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegistrationRepository extends JpaRepository<Registration, Integer> {
}
