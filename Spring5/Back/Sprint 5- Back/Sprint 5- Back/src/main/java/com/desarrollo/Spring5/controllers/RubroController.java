package com.desarrollo.Spring5.controllers;

import com.desarrollo.Spring5.entities.Rubro;
import com.desarrollo.Spring5.services.RubroServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubro")
public class RubroController extends BaseControllerImpl<Rubro, RubroServiceImpl>{
}
