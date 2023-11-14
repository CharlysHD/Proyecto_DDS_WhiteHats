package com.desarrollo.Spring5.services;

import com.desarrollo.Spring5.entities.Factura;

import java.util.List;

public interface FacturaService extends BaseService<Factura, Long>{
    List<Factura> search(String filtro) throws Exception;
}
