package com.desarrollo.Spring3.services;

import com.desarrollo.Spring3.entities.Domicilio;
import com.desarrollo.Spring3.repositories.BaseRepository;
import com.desarrollo.Spring3.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService{
    @Autowired
    private DomicilioRepository domicilioRepository;
    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {super(baseRepository);}
}