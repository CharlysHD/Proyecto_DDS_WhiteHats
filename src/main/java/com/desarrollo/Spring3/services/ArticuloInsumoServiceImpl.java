package com.desarrollo.Spring3.services;

import com.desarrollo.Spring3.entities.ArticuloInsumo;
import com.desarrollo.Spring3.repositories.ArticuloInsumoRepository;
import com.desarrollo.Spring3.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService{
    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;
    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository) {
        super(baseRepository);
    }
}
