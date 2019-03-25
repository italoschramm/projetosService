package com.italo.projetos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.projetos.dto.ClienteDTO;
import com.italo.projetos.model.Cliente;
import com.italo.projetos.model.Empresa;
import com.italo.projetos.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmpresaService empresaService;

	@Override
	public boolean cadastrar(ClienteDTO cliente) {
		if(existeCliente(cliente.getEmail())) {
			return false;
		}
		
		Cliente clienteObj = new Cliente();
		Empresa empresa = null;
		try {
			empresa = empresaService.buscarPorID(cliente.getIdEmpresa());
		}catch(Exception e) {
			throw new RuntimeException("Empresa não encontrada!");
		}
		clienteObj.setNomeCompleto(cliente.getNomeCompleto());
		clienteObj.setEmail(cliente.getEmail());
		clienteObj.setDataNascimento(cliente.getDataNascimento());
		clienteObj.setEmpresa(empresa);
		clienteRepository.save(clienteObj);
		return true;
	}

	private boolean existeCliente(String email) {
		List<Cliente> listaCliente = (List<Cliente>) clienteRepository.findAll();
		for(Cliente cliente : listaCliente) {
			if(cliente.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
}
