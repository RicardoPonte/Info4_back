package br.com.info4.teste.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.info4.teste.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
	//Usuario buscaEmail(String email);
	Optional<Usuario> findByEmail(String email);
}
