package com.desarrollo.Spring4.controllers;

import com.desarrollo.Spring4.entities.Venta;
import com.desarrollo.Spring4.services.VentaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/venta")
public class VentaController extends BaseControllerImpl<Venta, VentaServiceImpl>{
}
