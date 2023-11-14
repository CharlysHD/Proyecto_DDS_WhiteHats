package com.desarrollo.Spring5.controllers;

import com.desarrollo.Spring5.entities.VentaFactura;
import com.desarrollo.Spring5.services.VentaFacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ventafactura")
public class VentaFacturaController extends BaseControllerImpl<VentaFactura, VentaFacturaServiceImpl>{
}
