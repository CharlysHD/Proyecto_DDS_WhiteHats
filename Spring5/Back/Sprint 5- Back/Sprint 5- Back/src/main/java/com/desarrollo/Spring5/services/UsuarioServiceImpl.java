package com.desarrollo.Spring5.services;

import com.desarrollo.Spring5.entities.Usuario;
import com.desarrollo.Spring5.repositories.BaseRepository;
import com.desarrollo.Spring5.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository, UsuarioRepository usuarioRepository) {
        super(baseRepository);
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> search(String filtro) throws Exception {
        try {
            //List<Persona> personas= personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro);
            //List<Persona> personas = personaRepository.search(filtro);
            List<Usuario> usuarios = usuarioRepository.searchNativo(filtro);
            return usuarios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Usuario> search(String filtro, Pageable pageable) throws Exception {
        try{
            //Page<Persona> personas= personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro,pageable);
            //Page<Persona> personas = personaRepository.search(filtro,pageable);
            Page<Usuario> usuarios= usuarioRepository.searchNativo(filtro, pageable);
            return usuarios;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}