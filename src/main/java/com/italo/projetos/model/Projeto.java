package com.italo.projetos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROJETO")
public class Projeto {
	
	@Id
	@GeneratedValue
	private Long idProjeto;
	
	@Column(name="NOMEPROJETO")
	private String nomeProjeto;
	
	@Column(name="STATUSPROJETO")
	private boolean statusProjeto;
	
	@Column(name="DATAATIVACAO")
	private Date dataAtivacao; 
	
	@Column(name="DATADESTIVACAO")
	private Date dataDesativacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa", nullable = false)
	private Empresa empresa;

	/**
	 * @return the idProjeto
	 */
	public Long getIdProjeto() {
		return idProjeto;
	}

	/**
	 * @param idProjeto the idProjeto to set
	 */
	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}

	/**
	 * @return the nomeProjeto
	 */
	public String getNomeProjeto() {
		return nomeProjeto;
	}

	/**
	 * @param nomeProjeto the nomeProjeto to set
	 */
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	/**
	 * @return the statusProjeto
	 */
	public boolean isStatusProjeto() {
		return statusProjeto;
	}

	/**
	 * @param statusProjeto the statusProjeto to set
	 */
	public void setStatusProjeto(boolean statusProjeto) {
		this.statusProjeto = statusProjeto;
	}

	/**
	 * @return the dataAtivacao
	 */
	public Date getDataAtivacao() {
		return dataAtivacao;
	}

	/**
	 * @param dataAtivacao the dataAtivacao to set
	 */
	public void setDataAtivacao(Date dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	/**
	 * @return the dataDesativacao
	 */
	public Date getDataDesativacao() {
		return dataDesativacao;
	}

	/**
	 * @param dataDesativacao the dataDesativacao to set
	 */
	public void setDataDesativacao(Date dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
