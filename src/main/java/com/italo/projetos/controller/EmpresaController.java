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

import com.italo.projetos.dto.EmpresaDTO;
import com.italo.projetos.exception.CampoObrigatorioException;
import com.italo.projetos.model.Empresa;
import com.italo.projetos.service.EmpresaService;

@RestController
@RequestMapping(value="/api/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping("/incluir")
	@ResponseBody
	public String incluir(@RequestBody @Valid EmpresaDTO empresa) throws Exception{
		
		if (empresa.getNomeEmpresa().isEmpty()) {
			throw new CampoObrigatorioException("Nome da empresa é obrigatorio!");
		}
		
		empresaService.incluir(empresa);
		return "Salvo com sucesso!";
	}
	
	@RequestMapping("/consultar")
	@ResponseBody
	public ResponseEntity<Empresa> buscar(@RequestBody EmpresaDTO empresa){
		if(empresa.getIdEmpresa() == null) {
			throw new CampoObrigatorioException("É necessário o ID da empresa para pesquisa!");
		}
		Empresa result = empresaService.buscarPorID(empresa.getIdEmpresa());
		return new ResponseEntity<Empresa>(result, HttpStatus.OK);
	}
	
	@RequestMapping("/listar")
	public List<Empresa> listar(){
		List<Empresa> result = empresaService.listar();
		return result;
	}
	
	@RequestMapping("/atualizar")
	@ResponseBody
	public String atualizar(@RequestBody @Valid EmpresaDTO empresa) throws CampoObrigatorioException{	
	    
		if(empresa.getIdEmpresa() == null){
			throw new CampoObrigatorioException("Campo ID e obrigatorio para atualizar!");
		}
		
		empresaService.atualizar(empresa);
		return "Atualizado com sucesso!";
	}
	
	@RequestMapping("/deletar")
	@ResponseBody
	public String deletar(@RequestBody @Valid EmpresaDTO empresa) throws CampoObrigatorioException{	
	    
		if(empresa.getIdEmpresa() == null){
			throw new CampoObrigatorioException("Campo ID e obrigatorio para deletar!");
		}
		
		empresaService.deletar(empresa.getIdEmpresa());
		return "Deletado com sucesso!";
	}
	
}
