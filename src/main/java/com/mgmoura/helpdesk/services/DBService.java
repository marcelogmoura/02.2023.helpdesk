package com.mgmoura.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgmoura.helpdesk.domain.Chamado;
import com.mgmoura.helpdesk.domain.Cliente;
import com.mgmoura.helpdesk.domain.Tecnico;
import com.mgmoura.helpdesk.domain.enums.Perfil;
import com.mgmoura.helpdesk.domain.enums.Prioridade;
import com.mgmoura.helpdesk.domain.enums.Status;
import com.mgmoura.helpdesk.repositories.ChamadoRepository;
import com.mgmoura.helpdesk.repositories.ClienteRepository;
import com.mgmoura.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Ed Motta", "15164286254", "ed@email.com", "123");	
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "67270076677", "linus@email.com", "012");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA	, Status.ANDAMENTO, "Chamado #01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}