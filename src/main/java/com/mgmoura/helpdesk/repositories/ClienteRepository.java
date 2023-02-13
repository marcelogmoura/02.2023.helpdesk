package com.mgmoura.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgmoura.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
