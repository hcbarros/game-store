package br.com.supera.game.store.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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
			Usuario user = getUsuarioByCpf(u.getCpf());
			user.setCart(u.getCart());
			user.setEndereco(u.getEndereco());
			return repo.save(user);
		}
		return repo.save(u);
	}
	
	public List<Usuario> getAll() {
		return repo.findAll();
	}
	
	public Usuario getUsuarioById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}
	
	public Usuario getUsuarioByCpf(String cpf) {
		return repo.findByCpf(cpf);
	}

	
}
