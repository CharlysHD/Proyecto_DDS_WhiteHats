package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Venta;

import java.util.List;

public interface VentaService extends BaseService<Venta, Long>{
    List<Venta> search(String filtro) throws Exception;
}
