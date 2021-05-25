package br.com.supera.game.store.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supera.game.store.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByCpf(String cpf);
	boolean existsByCpf(String cpf);
}