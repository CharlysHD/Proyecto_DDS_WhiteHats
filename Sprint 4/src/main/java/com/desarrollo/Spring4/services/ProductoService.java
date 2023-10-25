package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductoService extends BaseService<Producto, Long>{
    List<Producto> search(String filtro) throws Exception;

    Page<Producto> search(String filtro, Pageable pageable) throws Exception;
}
