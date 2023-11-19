package com.desarrollo.Spring4.controllers;

import com.desarrollo.Spring4.entities.Empleado;
import com.desarrollo.Spring4.services.EmpleadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/empleado")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String inicio, String fin) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(inicio, fin));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" +e.getMessage() + "\"}"));
        }
    }
}
