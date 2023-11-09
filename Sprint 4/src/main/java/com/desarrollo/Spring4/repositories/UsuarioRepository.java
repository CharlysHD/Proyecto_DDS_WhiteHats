package com.desarrollo.Spring4.repositories;

import com.desarrollo.Spring4.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
    //Query nativa

    @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE %:filtro%",
            nativeQuery = true
            //x defecto natQuery viene desactivado
    )
    List<Usuario> searchNativo(@Param("filtro") String filtro);

    //Querys q reciben paginacion
    @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM usuario",//permite contar la cant de paginas
            nativeQuery = true//x defecto natQuery viene desactivado
    )
    Page<Usuario> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
