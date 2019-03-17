package com.italo.projetos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPRESA")
public class Empresa {

	@Id
	@GeneratedValue
	private Long idEmpresa;
	
	@Column(name="NOMEEMPRESA")
	private String nomeEmpresa;
	
	@OneToMany(cascade = CascadeType.ALL,
				fetch = FetchType.EAGER,
				mappedBy = "empresa")
	private List<Projeto> projetos;

	/**
	 * @return the idEmpresa
	 */
	public Long getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa the idEmpresa to set
	 */
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return the nomeEmpresa
	 */
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	/**
	 * @param nomeEmpresa the nomeEmpresa to set
	 */
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	/**
	 * @return the projetos
	 */
	public List<Projeto> getProjetos() {
		return projetos;
	}

	/**
	 * @param projetos the projetos to set
	 */
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
}
