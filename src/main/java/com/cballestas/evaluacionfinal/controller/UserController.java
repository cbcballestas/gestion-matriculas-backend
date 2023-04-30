package com.cballestas.evaluacionfinal.controller;

import com.cballestas.evaluacionfinal.dto.UserDTO;
import com.cballestas.evaluacionfinal.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> readAll() throws Exception {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") //PathVariable | ${} EL Expression Language
    public ResponseEntity<UserDTO> readById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO dto) throws Exception {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody UserDTO dto) throws Exception {
        dto.setIdUser(id);
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
