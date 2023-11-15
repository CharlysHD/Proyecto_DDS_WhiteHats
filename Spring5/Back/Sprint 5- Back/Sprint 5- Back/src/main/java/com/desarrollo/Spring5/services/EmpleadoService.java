package com.desarrollo.Spring5.services;

import com.desarrollo.Spring5.entities.Empleado;

import java.util.List;
public interface EmpleadoService extends BaseService<Empleado, Long>{
  List<Empleado> search(String filtro) throws Exception;
}
