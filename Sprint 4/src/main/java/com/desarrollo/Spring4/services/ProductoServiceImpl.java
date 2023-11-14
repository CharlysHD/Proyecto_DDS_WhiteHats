package com.desarrollo.Spring4.services;

import com.desarrollo.Spring4.entities.Producto;
import com.desarrollo.Spring4.repositories.BaseRepository;
import com.desarrollo.Spring4.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;
    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> search(String filtro) throws Exception {
        try {
            List<Producto> productos = productoRepository.searchNativo(filtro);
            return productos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Producto> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Producto> productos= productoRepository.searchNativo(filtro, pageable);
            return productos;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<Object> getTopProducts(String name) {
        return productoRepository.getTopProducts(name);
    }

}
