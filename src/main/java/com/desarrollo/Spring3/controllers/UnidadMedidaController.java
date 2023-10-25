package com.desarrollo.Spring3.controllers;

import com.desarrollo.Spring3.entities.UnidadMedida;
import com.desarrollo.Spring3.services.UnidadMedidaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/unidadmedida")
public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida, UnidadMedidaServiceImpl>{
}
