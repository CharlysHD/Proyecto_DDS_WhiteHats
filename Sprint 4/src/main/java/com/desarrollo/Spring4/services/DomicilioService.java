package com.desarrollo.Spring4.services;
import com.desarrollo.Spring4.DTOs.ClienteDomicilioDTO;
import com.desarrollo.Spring4.entities.Cliente;
import com.desarrollo.Spring4.entities.Domicilio;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long>{
    public List<Domicilio> mostrarDomiciliosCliente(Cliente cliente) throws Exception;
    public  Domicilio modificarDomicilioCliente(ClienteDomicilioDTO domicilioDTO) throws Exception;
}
