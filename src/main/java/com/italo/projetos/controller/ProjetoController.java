package com.italo.projetos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.italo.projetos.dto.ProjetoDTO;
import com.italo.projetos.exception.CampoObrigatorioException;
import com.italo.projetos.service.ProjetoService;
import com.italo.projetos.vo.ProjetoVO;

@RestController
@RequestMapping(value="/api/projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoService projetoService;
	
	@RequestMapping("/incluir")
	@ResponseBody
	public String incluir(@RequestBody @Valid ProjetoDTO projeto) throws Exception{
		
		if (projeto.getNomeProjeto().isEmpty()) {
			throw new CampoObrigatorioException("Nome do Projeto é obrigatorio!");
		}
		
		if (projeto.getIdEmpresa() == null) {
			throw new CampoObrigatorioException("ID da Empresa é obrigatorio!");
		}
		
		return projetoService.incluir(projeto);
	}
	
	@RequestMapping("/consultar")
	@ResponseBody
	public ResponseEntity<ProjetoVO> buscar(@RequestBody ProjetoDTO projeto){
		if(projeto.getIdProjeto() == null) {
			throw new CampoObrigatorioException("É necessário o ID do projeto para pesquisa!");
		}
		ProjetoVO result = projetoService.buscarPorID(projeto.getIdProjeto());
		return new ResponseEntity<ProjetoVO>(result, HttpStatus.OK);
	}
	
	@RequestMapping("/listar")
	public List<ProjetoVO> listar(){
		List<ProjetoVO> result = projetoService.listar();
		return result;
	}
	
	@RequestMapping("/atualizar")
	@ResponseBody
	public String atualizar(@RequestBody @Valid ProjetoDTO projeto) throws CampoObrigatorioException{	
	    
		if(projeto.getIdProjeto() == null){
			throw new CampoObrigatorioException("Campo ID e obrigatorio para atualizar!");
		}
		
		projetoService.atualizar(projeto);
		return "Atualizado com sucesso!";
	}
	
	@RequestMapping("/deletar")
	@ResponseBody
	public String deletar(@RequestBody @Valid ProjetoDTO projeto) throws CampoObrigatorioException{	
	    
		if(projeto.getIdProjeto() == null){
			throw new CampoObrigatorioException("Campo ID e obrigatorio para deletar!");
		}
		
		projetoService.deletar(projeto.getIdProjeto());
		return "Deletado com sucesso!";
	}

}
