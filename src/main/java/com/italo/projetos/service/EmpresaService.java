package com.italo.projetos.service;

import java.util.List;

import com.italo.projetos.dto.EmpresaDTO;
import com.italo.projetos.model.Empresa;

public interface EmpresaService {
	
	public void incluir(EmpresaDTO empresa);
	public Empresa buscarPorID(Long idEmpresa);
	public List<Empresa> listar();
	public void atualizar(EmpresaDTO empresa);
	public void deletar(Long idEmpresa);
}
