package com.mgmoura.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgmoura.helpdesk.domain.Chamado;
import com.mgmoura.helpdesk.domain.Cliente;
import com.mgmoura.helpdesk.domain.Tecnico;
import com.mgmoura.helpdesk.domain.enums.Prioridade;
import com.mgmoura.helpdesk.domain.enums.Status;
import com.mgmoura.helpdesk.dtos.ChamadoDTO;
import com.mgmoura.helpdesk.exceptions.ObjectNotFoundException;
import com.mgmoura.helpdesk.repositories.ChamadoRepository;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService; 
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id); // pode ou nao encontrar um chamado
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}
	
	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Chamado chamado = new Chamado();
		if(obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toNum(obj.getPrioridade()));
		chamado.setStatus(Status.toNum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;
	}

}
