package com.desarrollo.Spring5.services;

import com.desarrollo.Spring5.entities.Empleado;
import com.desarrollo.Spring5.repositories.BaseRepository;
import com.desarrollo.Spring5.repositories.EmpleadoRepository;
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
    public List<Empleado> search(String inicio, String fin) throws Exception {
        try{
            List<Empleado> empleados= empleadoRepository.searchNativo(inicio, fin);
            return empleados;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
