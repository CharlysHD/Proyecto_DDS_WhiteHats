package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Empleado;
import com.desarrollo.Spring4.repositories.BaseRepository;
import com.desarrollo.Spring4.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Long> implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;
    public EmpleadoServiceImpl(BaseRepository<Empleado, Long> baseRepository) {
        super(baseRepository);
    }
    
    @Override
    public List<Empleado> search(String filtro) throws Exception {
        try{
            List<Empleado> empleados= empleadoRepository.searchNativo(filtro);
            return empleados;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
