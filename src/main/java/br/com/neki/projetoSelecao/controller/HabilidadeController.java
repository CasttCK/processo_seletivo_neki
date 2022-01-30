package br.com.neki.projetoSelecao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.projetoSelecao.entity.Habilidade;
import br.com.neki.projetoSelecao.repository.HabilidadeRepository;
import br.com.neki.projetoSelecao.service.HabilidadeService;

@RestController
@RequestMapping("/skill")
public class HabilidadeController {

	
	@Autowired
	HabilidadeRepository habilidadeRepository;
	
	@Autowired
	HabilidadeService habilidadeService;
	
	
	@GetMapping("/listarTudo")
	public ResponseEntity<List<Habilidade>> listar() {
		List<Habilidade> skills = habilidadeService.listarUsuarios();
		return ResponseEntity.ok(skills);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Habilidade> buscarPorId(@PathVariable Integer id) {
		Optional<Habilidade> skills = habilidadeService.listarPorId(id);
		if (skills.isPresent()) {
			return ResponseEntity.ok(skills.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/inserir")
	public Habilidade inserirHabilidade(@RequestBody Habilidade skill) {
		return habilidadeService.inserirUsuario(skill);
	}
	
	@PutMapping("/atualizar/{id}")
    public Habilidade atualizarHabilidade(@RequestBody Habilidade skill) {
        return habilidadeService.atualizarUsuario(skill);
    }

	@DeleteMapping("/deletar")
	public void deletarHabilidade(@RequestBody Habilidade skill) {
		habilidadeService.deletarUsuario(skill);
	}

}
