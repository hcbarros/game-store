package br.com.supera.game.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supera.game.store.model.Usuario;
import br.com.supera.game.store.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	
	public Usuario saveUser(Usuario u) {
		
		boolean exists = repo.existsByCpf(u.getCpf());
		if(exists) {
			Usuario user = getUsuario(u.getCpf());
			user.setCart(u.getCart());
			user.setEndereco(u.getEndereco());
			return repo.save(user);
		}
		return repo.save(u);
	}
	
	public Usuario getUsuario(String cpf) {
		return repo.findByCpf(cpf);
	}

	
}
