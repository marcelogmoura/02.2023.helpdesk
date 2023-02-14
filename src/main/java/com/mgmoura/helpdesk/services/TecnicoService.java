package com.mgmoura.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgmoura.helpdesk.domain.Tecnico;
import com.mgmoura.helpdesk.exceptions.ObjectNotFoundException;
import com.mgmoura.helpdesk.repositories.TecnicoRepository;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, id: " +id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

}



