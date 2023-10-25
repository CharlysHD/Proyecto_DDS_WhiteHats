package com.desarrollo.Spring3.repositories;

import com.desarrollo.Spring3.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
