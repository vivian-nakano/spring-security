package org.generation.blogPessoal.controller;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@org.springframework.stereotype.Service // camada de serviço
public class Service {

	@Autowired
	private UsuarioRepository repository; // injeção de repositório

	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);

		return repository.save(usuario);

		// finalidade de criptografar de senha
		// cria método cadastrarUsuario, salvar dentro da tabela
		// service é obrigatório para senha
	}
}