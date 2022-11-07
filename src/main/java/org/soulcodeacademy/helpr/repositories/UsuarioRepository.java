package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
}


// Métodos presentes
// - findAll => SELECT *FROM usuario;
// - findById => SELECT *FROM usuario WHERE id= ?;
// - save => INSERT INTO (caso id nullo)  ou UPDATE (caso id não nulo);
// - delete => DELETE FROM usuario WHERE id =? ;
