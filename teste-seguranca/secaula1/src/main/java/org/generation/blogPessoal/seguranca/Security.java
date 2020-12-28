package org.generation.blogPessoal.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration //padroniza configurações que tem na página
@EnableWebSecurity 
public class Security extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers(HttpMethod.POST, "/tema").permitAll()
//		.antMatchers(HttpMethod.POST, "/postagens").permitAll()
		.antMatchers(HttpMethod.GET, "/tema").permitAll()
		.anyRequest().authenticated()
		
		//caminhar para conseguir entrar, debaixo é para sair
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

		.and().csrf().disable(); //fator que habilita e desabilita o processo. tem que deixar cors ligado para segurança
	}

}
