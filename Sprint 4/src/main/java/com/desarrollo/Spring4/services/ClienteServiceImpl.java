package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Cliente;
import com.desarrollo.Spring4.repositories.ClienteRepository;
import com.desarrollo.Spring4.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.PageRequest;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository){
        super(baseRepository);
        this.clienteRepository= clienteRepository;
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {
        try{
            List<Cliente> clientes= clienteRepository.searchNativo(filtro);
            return clientes;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    @Override
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Cliente> clientes= clienteRepository.searchNativo(filtro, pageable);
            return clientes;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<Object> getTop5UsersOrders(int limit) {
        List<Object> users = clienteRepository.getTop5UsersOrders(PageRequest.of(0, limit));
        return users;
    }
}
