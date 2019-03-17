package com.italo.projetos.service;

import java.util.List;

import com.italo.projetos.dto.ProjetoDTO;
import com.italo.projetos.vo.ProjetoVO;

public interface ProjetoService {
	
	public String incluir(ProjetoDTO projeto);
	public ProjetoVO buscarPorID(Long idProjeto);
	public List<ProjetoVO> listar();
	public void atualizar(ProjetoDTO projeto);
	public void deletar(Long idProjeto);
}
