package br.com.neki.projetoSelecao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.projetoSelecao.entity.Usuario;
import br.com.neki.projetoSelecao.repository.UsuarioRepository;
import br.com.neki.projetoSelecao.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UsuarioService usuarioService;
	
	public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.encoder = encoder;
	}

	
	@GetMapping("/listarTudo")
	public ResponseEntity<List<Usuario>> listarTudo() {
		List<Usuario> usuarios = usuarioService.listarUsuarios();
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarTudo(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioService.listarPorId(id);
		return ResponseEntity.ok(usuario.get());
	}

	@PostMapping("/inserir")
	public Usuario inserirUser(@RequestBody Usuario usuario) {
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		return usuarioService.inserirUsuario(usuario);

	}

	@PutMapping("/atualizar")
    public Usuario atualizarUser(@RequestBody Usuario usuario) {
       usuario.setPassword(encoder.encode(usuario.getPassword()));
        return usuarioService.atualizarUsuario(usuario);
    }

	@DeleteMapping("/deletar/{id}")
	public void deletarUser(@RequestBody Usuario usuario) {
		usuarioService.deletarUsuario(usuario);
	}
	
}
