package com.cballestas.evaluacionfinal.service.impl;

import com.cballestas.evaluacionfinal.dto.RegistrationDTO;
import com.cballestas.evaluacionfinal.model.Registration;
import com.cballestas.evaluacionfinal.repository.IRegistrationRepository;
import com.cballestas.evaluacionfinal.service.IRegistrationService;
import com.cballestas.evaluacionfinal.util.CommonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private final IRegistrationRepository registrationRepository;
    private final CommonMapper mapper;

    @Override
    @Transactional
    public ResponseEntity<RegistrationDTO> saveRegistration(RegistrationDTO registrationDTO) {
        Registration registration = registrationRepository.save(
                mapper.convertToEntity(registrationDTO, Registration.class)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(
                mapper.convertToDto(registration, RegistrationDTO.class)
        );
    }
}
