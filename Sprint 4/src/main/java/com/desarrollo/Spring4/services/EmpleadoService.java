package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Empleado;

import java.util.List;
public interface EmpleadoService extends BaseService<Empleado, Long>{
  List<Empleado> search(String filtro) throws Exception;
}
