package br.com.neki.projetoSelecao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.projetoSelecao.entity.Usuario;
import br.com.neki.projetoSelecao.exceptions.NotFoundException;
import br.com.neki.projetoSelecao.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		if (usuarioRepository.findAll() == null) {
			throw new NotFoundException("Não encontrado.");
		}
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> listarPorId(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuarioRepository.findById(id);
		}
		 throw new NotFoundException("Usuário não encontrado.");  
	}

	
	public Usuario inserirUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	
	public Usuario atualizarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	
	public Usuario deletarUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
		return null;
	}
	
}
