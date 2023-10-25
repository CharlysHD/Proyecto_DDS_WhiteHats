package com.desarrollo.Spring3.services;

import com.desarrollo.Spring3.entities.Cliente;
import com.desarrollo.Spring3.repositories.ClienteRepository;
import com.desarrollo.Spring3.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository){
        super(baseRepository);
    }
}
