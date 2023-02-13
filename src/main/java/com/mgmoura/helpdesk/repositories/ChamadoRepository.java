package com.mgmoura.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgmoura.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
