package com.desarrollo.Spring5.controllers;

import com.desarrollo.Spring5.entities.Empleado;
import com.desarrollo.Spring5.services.EmpleadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/empleado")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl>{
  
  @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" +e.getMessage() + "\"}"));
        }
    }
}