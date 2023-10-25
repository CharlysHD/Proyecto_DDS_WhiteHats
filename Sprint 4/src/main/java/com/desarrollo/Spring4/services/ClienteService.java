package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long>{
    List<Cliente> search(String filtro) throws Exception;

    Page<Cliente> search(String filtro, Pageable pageable) throws Exception;
}
