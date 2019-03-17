package com.italo.projetos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.italo.projetos.model.Projeto;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long>{

}
