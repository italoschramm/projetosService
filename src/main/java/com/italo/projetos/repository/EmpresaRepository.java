package com.italo.projetos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.italo.projetos.model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long>{

}
