package br.com.neki.projetoSelecao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.projetoSelecao.entity.Habilidade;
import br.com.neki.projetoSelecao.exceptions.NotFoundException;
import br.com.neki.projetoSelecao.repository.HabilidadeRepository;

@Service
public class HabilidadeService {

	@Autowired
	HabilidadeRepository habilidadeRepository;

	public List<Habilidade> listarUsuarios() {
		if (habilidadeRepository.findAll() == null) {
			throw new NotFoundException("Não encontrado.");
		}
		return habilidadeRepository.findAll();
	}

	public Optional<Habilidade> listarPorId(Integer id) {
		Optional<Habilidade> usuario = habilidadeRepository.findById(id);
		if (usuario.isPresent()) {
			return habilidadeRepository.findById(id);
		}
		 throw new NotFoundException("Habilidade não encontrada.");  
	}

	
	public Habilidade inserirUsuario(Habilidade skill) {
		return habilidadeRepository.save(skill);
	}

	
	public Habilidade atualizarUsuario(Habilidade skill) {
		return habilidadeRepository.save(skill);
	}

	
	public Habilidade deletarUsuario(Habilidade skill) {
		habilidadeRepository.delete(skill);
		return null;
	}
	
}
