package com.cballestas.evaluacionfinal.service;

import com.cballestas.evaluacionfinal.dto.RegistrationDTO;
import org.springframework.http.ResponseEntity;

public interface IRegistrationService {
    ResponseEntity<RegistrationDTO> saveRegistration(RegistrationDTO registrationDTO);
}
