package com.desarrollo.Spring3.controllers;

import com.desarrollo.Spring3.entities.Rubro;
import com.desarrollo.Spring3.services.RubroServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubro")
public class RubroController extends BaseControllerImpl<Rubro, RubroServiceImpl>{
}
