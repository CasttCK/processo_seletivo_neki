package br.com.neki.projetoSelecao.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.projetoSelecao.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	

}