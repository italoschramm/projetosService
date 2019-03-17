package com.italo.projetos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.projetos.dto.EmpresaDTO;
import com.italo.projetos.model.Empresa;
import com.italo.projetos.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public void incluir(EmpresaDTO empresa) {
		Empresa empresaObj = new Empresa();
		empresaObj.setNomeEmpresa(empresa.getNomeEmpresa());
		empresaRepository.save(empresaObj);
	}

	@Override
	public Empresa buscarPorID(Long idEmpresa){
		try {
			 Empresa empresaResult = empresaRepository.findById(idEmpresa).get();
			 return empresaResult;
		}catch(Exception e) {
			throw new RuntimeException("Empresa não encontrada!");
		}
	}

	@Override
	public List<Empresa> listar() {
		
		return (List<Empresa>) empresaRepository.findAll();
	}

	@Override
	public void atualizar(EmpresaDTO empresa) {
		
		try {
			Empresa empresaResult = empresaRepository.findById(empresa.getIdEmpresa()).get();
			empresaResult.setNomeEmpresa(empresa.getNomeEmpresa());
			empresaRepository.save(empresaResult);
		}catch(Exception e) {
			throw new RuntimeException("Empresa não encontrada!");
		}
	}

	@Override
	public void deletar(Long idEmpresa) {
		
		try {
			empresaRepository.deleteById(idEmpresa);;
		}catch(Exception e) {
			throw new RuntimeException("Empresa não encontrada!");
		}
		
	}
	
}
