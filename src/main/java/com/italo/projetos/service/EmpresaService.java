package com.italo.projetos.service;

import java.util.List;

import com.italo.projetos.dto.EmpresaDTO;
import com.italo.projetos.model.Empresa;
import com.italo.projetos.model.Projeto;

public interface EmpresaService {
	
	public void incluir(EmpresaDTO empresa);
	public Empresa buscarPorID(Long idEmpresa);
	public List<EmpresaDTO> listar();
	public void atualizar(EmpresaDTO empresa);
	public void deletar(Long idEmpresa);
	public List<Projeto> listaProjetoAtivosEmpresa(Long idEmpresa);
}
