package com.cballestas.evaluacionfinal.controller;

import com.cballestas.evaluacionfinal.dto.RegistrationDTO;
import com.cballestas.evaluacionfinal.service.IRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final IRegistrationService service;

    /**
     * Método que se encarga de realizar el registro de matrículas
     * @param registrationDTO objeto de tipo RegistrationDTO
     * @return Objeto RegistrationDTO
     */
    @PostMapping
    public ResponseEntity<RegistrationDTO> saveRegistration(@Valid @RequestBody RegistrationDTO registrationDTO) {
        return service.saveRegistration(registrationDTO);
    }
}
