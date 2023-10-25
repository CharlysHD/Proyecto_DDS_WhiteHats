package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.ArticuloInsumo;
import com.desarrollo.Spring4.repositories.ArticuloInsumoRepository;
import com.desarrollo.Spring4.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService{
    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;
    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }

    @Override
    public List<ArticuloInsumo> search(String filtro) throws Exception {
        try {
            //List<Persona> personas= personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro);
            //List<Persona> personas = personaRepository.search(filtro);
            List<ArticuloInsumo> articulosInsumo = articuloInsumoRepository.searchNativo(filtro);
            return articulosInsumo;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<ArticuloInsumo> search(String filtro, Pageable pageable) throws Exception {
        try{
            //Page<Persona> personas= personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro,pageable);
            //Page<Persona> personas = personaRepository.search(filtro,pageable);
            Page<ArticuloInsumo> articulosInsumo= articuloInsumoRepository.searchNativo(filtro, pageable);
            return articulosInsumo;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}
