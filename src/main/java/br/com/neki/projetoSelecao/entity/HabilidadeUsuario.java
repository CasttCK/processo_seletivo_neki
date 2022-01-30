package br.com.neki.projetoSelecao.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class HabilidadeUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="skill_id")
	private Habilidade skill;
	
	@Column(name="knowledge_level")
	private Long NivelConhecimento;
	
	@Column
	private LocalDate CreatedAt;
	
	@Column
	private LocalDate UpdateAt;

	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Habilidade getSkill() {
		return skill;
	}

	public void setSkill(Habilidade skill) {
		this.skill = skill;
	}

	public Long getNivelConhecimento() {
		return NivelConhecimento;
	}

	public void setNivelConhecimento(Long nivelConhecimento) {
		NivelConhecimento = nivelConhecimento;
	}

	public LocalDate getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		CreatedAt = createdAt;
	}

	public LocalDate getUpdateAt() {
		return UpdateAt;
	}

	public void setUpdateAt(LocalDate updateAt) {
		UpdateAt = updateAt;
	}
	
	
}
