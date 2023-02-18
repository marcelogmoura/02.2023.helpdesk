package com.mgmoura.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mgmoura.helpdesk.domain.Chamado;
import com.mgmoura.helpdesk.domain.Cliente;
import com.mgmoura.helpdesk.domain.Tecnico;
import com.mgmoura.helpdesk.domain.enums.Perfil;
import com.mgmoura.helpdesk.domain.enums.Prioridade;
import com.mgmoura.helpdesk.domain.enums.Status;
import com.mgmoura.helpdesk.repositories.ChamadoRepository;
import com.mgmoura.helpdesk.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Ed Motta", "15164286254", "ed@email.com", encoder.encode("123"));	
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Ana", "39910882744", "ana@email.com", encoder.encode("123"));	
		Tecnico tec3 = new Tecnico(null, "Ace Frehley", "18976238877", "ace@email.com", encoder.encode("123"));	
		Tecnico tec4 = new Tecnico(null, "Paul Rodgers", "02483111238", "paul@email.com", encoder.encode("123"));	
		Tecnico tec5 = new Tecnico(null, "Carmen Miranda", "74264394880", "carmen@email.com", encoder.encode("123"));	
		
		Cliente cli1 = new Cliente(null, "Igor Jr", "35234815382", "jr@email.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Albert Einsten", "53264431980", "alb@email.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Suzana Lira", "62792386606", "suz@email.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Zeca Gomes", "52977716688", "zeca@email.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Ozzy Osbourne", "41142587797", "oz@email.com", encoder.encode("123"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA	, Status.ANDAMENTO, "Chamado #01", "Teste chamado 1", tec2, cli4);
		Chamado c2 = new Chamado(null, Prioridade.ALTA	, Status.ABERTO, "Chamado #02", "Teste chamado 2", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA	, Status.ENCERRADO, "Chamado #03", "Teste chamado 3", tec3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA	, Status.ABERTO, "Chamado #04", "Teste chamado 4", tec4, cli4);
		Chamado c5 = new Chamado(null, Prioridade.MEDIA	, Status.ANDAMENTO, "Chamado #05", "Teste chamado 5", tec5, cli5);
		Chamado c6 = new Chamado(null, Prioridade.BAIXA	, Status.ENCERRADO, "Chamado #06", "Teste chamado 6", tec5, cli4);
		
		pessoaRepository.saveAll(Arrays.asList(tec1 , tec2 , tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3 ,c4, c5, c6));
	}
}
