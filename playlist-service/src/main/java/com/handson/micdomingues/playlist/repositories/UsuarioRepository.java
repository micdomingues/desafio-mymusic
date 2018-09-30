package com.handson.micdomingues.playlist.repositories;

import com.handson.micdomingues.playlist.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findByNome(String nome);
}
