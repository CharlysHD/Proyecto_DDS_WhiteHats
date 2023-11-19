package com.desarrollo.Spring4.controllers;

import com.desarrollo.Spring4.entities.Pedido;
import com.desarrollo.Spring4.enums.EstadoPedido;
import com.desarrollo.Spring4.services.PedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro, EstadoPedido estado) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, estado));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" +e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/search/fechas")
    public ResponseEntity<?> search(@RequestParam String desde, String hasta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(desde, hasta));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" +e.getMessage() + "\"}"));
        }
    }
}
