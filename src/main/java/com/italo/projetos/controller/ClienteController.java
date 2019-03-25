package com.italo.projetos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.italo.projetos.dto.ClienteDTO;
import com.italo.projetos.exception.CampoObrigatorioException;
import com.italo.projetos.model.Projeto;
import com.italo.projetos.service.ClienteService;
import com.italo.projetos.service.EmpresaService;

@RestController
@RequestMapping(value="/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping("/cadastrar")
	@ResponseBody
	public StringBuilder cadastrar(@RequestBody @Valid ClienteDTO cliente) throws Exception{
		
		if (cliente.getNomeCompleto().isEmpty() || cliente.getEmail().isEmpty() || 
				cliente.getDataNascimento()==null || cliente.getIdEmpresa()==null) {
			throw new CampoObrigatorioException("Todos os campes são obrigatorios!");
		}

		StringBuilder resultado = new StringBuilder();
		
		if(clienteService.cadastrar(cliente)) {
			resultado.append("Salvo com sucesso!");
			return resultado;
		}else {
			List<Projeto> projetos = empresaService.listaProjetoAtivosEmpresa(cliente.getIdEmpresa());
			if (projetos.isEmpty()) {
				resultado.append("Cadastro já efetuado!");
				resultado.append("Nenhum projeto disponivel para a empresa do Cliente!");
				return resultado;
			}else {
				for(Projeto projeto : projetos) {
					resultado.append("Nome Projeto: " + projeto.getNomeProjeto() + "Id Projeto: " + projeto.getIdProjeto());
				}
				return resultado;
			}
			
		}
	}
}
