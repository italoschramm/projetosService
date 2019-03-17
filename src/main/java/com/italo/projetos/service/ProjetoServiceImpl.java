package com.italo.projetos.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.projetos.dto.ProjetoDTO;
import com.italo.projetos.model.Empresa;
import com.italo.projetos.model.Projeto;
import com.italo.projetos.repository.ProjetoRepository;
import com.italo.projetos.util.Util;
import com.italo.projetos.vo.ProjetoVO;

@Service
public class ProjetoServiceImpl implements ProjetoService{
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	
	@Override
	public String incluir(ProjetoDTO projeto) {
		
		Projeto projetoObj = new Projeto();
		boolean vigenciaExistente = false;
			
		try {
			Empresa empresa = empresaService.buscarPorID(projeto.getIdEmpresa());
			for(Projeto projetoBusca : empresa.getProjetos()) {
				if(projeto.isStatusProjeto() && projeto.getDataAtivacao().before(projetoBusca.getDataDesativacao())) {
					projetoObj.setDataAtivacao(projetoBusca.getDataDesativacao());
					vigenciaExistente = true;
				}
			}
		}catch (Exception e) {
			throw new RuntimeException("Empresa não encontrada!");
		}
		
		if(projetoObj.getDataAtivacao() == null) {
			projetoObj.setDataAtivacao(projeto.getDataAtivacao());
		}
			
		projetoObj.setNomeProjeto(projeto.getNomeProjeto());
		projetoObj.setStatusProjeto(projeto.isStatusProjeto());
		projetoObj.setEmpresa(empresaService.buscarPorID(projeto.getIdEmpresa()));
			
		Util util = new Util();
		projetoObj.setDataDesativacao(util.gerarDataDesativacao(projetoObj.getDataAtivacao()));
			
		projetoRepository.save(projetoObj);
			
		if(!vigenciaExistente) {
				return "Salvo com sucesso!";
		}else {
				return "Vigência existente! Novo perído de vigencia: " + projetoObj.getDataAtivacao().toString() + " até "
						+ projetoObj.getDataDesativacao().toString();
		}
	
	}

	@Override
	public ProjetoVO buscarPorID(Long idProjeto){
		try {
			 Projeto result = projetoRepository.findById(idProjeto).get();
			 ProjetoVO projetoVO = new ProjetoVO();
			 projetoVO.setNomeProjeto(result.getNomeProjeto());
			 projetoVO.setStatusProjeto(result.isStatusProjeto());
			 projetoVO.setDataAtivacao(result.getDataAtivacao());
			 projetoVO.setDataDesativacao(result.getDataDesativacao());
			 projetoVO.setIdEmpresa(result.getEmpresa().getIdEmpresa());
			 return projetoVO;
		}catch(Exception e) {
			throw new RuntimeException("Projeto não encontrada!");
		}
	}

	@Override
	public List<ProjetoVO> listar() {
		List<Projeto> result = (List<Projeto>) projetoRepository.findAll();
		List<ProjetoVO> projetoList = new ArrayList<ProjetoVO>();
		for(Projeto projeto : result) {
			if(projeto.isStatusProjeto()) {
				ProjetoVO projetoObj = new ProjetoVO();
				projetoObj.setNomeProjeto(projeto.getNomeProjeto());
				projetoObj.setIdEmpresa(projeto.getEmpresa().getIdEmpresa());
				projetoObj.setStatusProjeto(projeto.isStatusProjeto());
				projetoObj.setDataAtivacao(projeto.getDataAtivacao());
				projetoObj.setDataDesativacao(projeto.getDataDesativacao());
				projetoList.add(projetoObj);
			}
		}
		return projetoList;
	}

	@Override
	public void atualizar(ProjetoDTO projeto) {
		
		try {
			Projeto projetoObj = projetoRepository.findById(projeto.getIdProjeto()).get();
			projetoObj.setNomeProjeto(projeto.getNomeProjeto());
			projetoObj.setStatusProjeto(projeto.isStatusProjeto());
			projetoObj.setDataAtivacao(projeto.getDataAtivacao());
			
			//Gerar data de desativação
			Calendar c = Calendar.getInstance();
			c.setTime(projeto.getDataAtivacao());
			c.add(Calendar.YEAR, 1);
			projetoObj.setDataDesativacao(c.getTime());
			
			projetoObj.setEmpresa(empresaService.buscarPorID(projeto.getIdEmpresa()));
			projetoRepository.save(projetoObj);
		}catch(Exception e) {
			throw new RuntimeException("Projeto não encontrada!");
		}
	}

	@Override
	public void deletar(Long idProjeto) {
		
		try {
			projetoRepository.deleteById(idProjeto);
		}catch(Exception e) {
			throw new RuntimeException("Projeto não encontrada!");
		}
		
	}

}
