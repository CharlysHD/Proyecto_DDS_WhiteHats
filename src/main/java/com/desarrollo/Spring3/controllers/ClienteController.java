package com.desarrollo.Spring3.controllers;

import com.desarrollo.Spring3.entities.Cliente;
import com.desarrollo.Spring3.services.ClienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cliente")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{
}
