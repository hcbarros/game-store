package br.com.supera.game.store.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.model.Cart;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.Usuario;
import br.com.supera.game.store.service.GameStoreService;
import br.com.supera.game.store.service.UsuarioService;


@RestController
@Validated
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping(value = "{cpf}")
	public Usuario getUsuario(@PathVariable String cpf) {
		return usuarioService.getUsuario(cpf);
	}
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario saveUser(@RequestBody @Valid Usuario usuario) {
		return usuarioService.saveUser(usuario);
	}
	
}


