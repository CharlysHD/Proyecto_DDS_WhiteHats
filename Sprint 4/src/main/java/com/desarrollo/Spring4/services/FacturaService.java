package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Factura;

import java.util.List;

public interface FacturaService extends BaseService<Factura, Long>{
    List<Factura> search(String filtro) throws Exception;
}
