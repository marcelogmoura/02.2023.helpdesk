package com.mgmoura.helpdesk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgmoura.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	// optional, pode o nao encontrar a Pessoa
	Optional<Pessoa> findByCpf(String cpf); 
	Optional<Pessoa> findByEmail(String email);
}
