package com.desarrollo.Spring4.controllers;
import com.desarrollo.Spring4.DTOs.ClienteDomicilioDTO;
import com.desarrollo.Spring4.entities.Cliente;
import com.desarrollo.Spring4.entities.Domicilio;
import com.desarrollo.Spring4.services.DomicilioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilio")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl> {

    @GetMapping("/mostrarDomicilioscliente")
    public ResponseEntity<?> mostrarDomiciliosCliente(Cliente cliente){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.mostrarDomiciliosCliente(cliente));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @Autowired
    DomicilioServiceImpl service;
    @PutMapping("/modificarDomicilioCliente")
    public ResponseEntity<?> modificarDomicilioCliente(ClienteDomicilioDTO domicilioDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.modificarDomicilioCliente(domicilioDTO));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
