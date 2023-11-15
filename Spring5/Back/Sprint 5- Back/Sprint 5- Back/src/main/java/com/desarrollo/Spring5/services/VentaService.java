package com.desarrollo.Spring5.services;

import com.desarrollo.Spring5.entities.Venta;

import java.util.List;

public interface VentaService extends BaseService<Venta, Long>{
    List<Venta> search(String filtro) throws Exception;
}
