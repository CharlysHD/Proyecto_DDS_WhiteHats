package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Empleado;
import com.desarrollo.Spring4.repositories.BaseRepository;
import com.desarrollo.Spring4.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Long> implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;
    public EmpleadoServiceImpl(BaseRepository<Empleado, Long> baseRepository) {
        super(baseRepository);
    }
}
