package com.desarrollo.Spring5.controllers;

import com.desarrollo.Spring5.entities.DetallePedido;
import com.desarrollo.Spring5.services.DetallePedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallepedido")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoServiceImpl>{
}
