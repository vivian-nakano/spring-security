package org.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {
	//implementar autoridade porque o role permite ou não algumas coisas
	
	//ATRIBUTOS
	@Id
	private String nomeRole;
	
	@ManyToMany(mappedBy="roles")
	private List<Usuario> usuarios;
	
	//MÉTODO DE AUTORIDADE
	@Override
	public String getAuthority() {
		return this.nomeRole; }

	//GETTERS E SETTERS
	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
